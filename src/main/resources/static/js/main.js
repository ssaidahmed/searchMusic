class Selector extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            id: 0,
            data:[]
        };
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(e) {
        this.setState({id: e.target.value}, ()=>{this.getArtists(this.state.id);});
    }
    getArtists(id){
        if(id===0) return;
        axios.get('http://localhost:8080/findart/'+id)
            .then(response => this.setState({data:response.data}))
    }

    render() {
        const mass = this.props.listOption;


        return(
            <div>
                <select onChange={this.handleChange}>
                    {mass.map((element, index) =>
                        <option key={index} value={element[1]}>
                            {element[0]}
                        </option>
                    )}
                </select>
                <Artistcompositions data ={this.state.data}/>
            </div>
        );
    }
}
class Data extends React.Component{
    constructor(props){
        super(props);
        this.state ={
            compositions:[]
        }

    }

    componentDidMount() {
        axios.get('http://localhost:8080/all')
            .then(response => this.setState({compositions:response.data}))
    }

    render(){

        return(
            <div>
                <h2>Найти исполнителя композиции:</h2>
                <Selector listOption = {this.state.compositions}/>
            </div>
        )
    }
}
function Item(props) {
    return <li>{props.firstName +" "+ props.lastName }</li>;
}

function Artistcompositions(props) {

    return (

        <ul>{props.data.map((element, index) => <Item key = {index} firstName = {element[1]} lastName={element[2]}/>)}</ul>
    );
}
ReactDOM.render(<Data/>, document.getElementById('root'));

