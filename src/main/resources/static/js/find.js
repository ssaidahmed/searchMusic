class FindAlbumComposition extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            select: '',
            albums:[],
            inputField:'',

        }

        // this.handleChange= this.handleChange.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit= this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value =  target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }
    // handleChange(event) {
    //     this.setState({ name: event.target.value });
    // }
    getAlbumsCompo(restMethod, name) {

        axios.get('http://localhost:8080/'+restMethod+'/'+name)
            .then(response => this.setState({albums:response.data}))
    }
    handleSubmit(event) {

        this.getAlbumsCompo(this.state.select, this.state.inputField);
        event.preventDefault();
    }


    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>

                    <select onChange={this.handleInputChange} name="select">
                        <option selected disabled>Выберите вариант поиска</option>
                        <option value="findallbum">Найти альбомы компо-и</option>
                        <option value="findcomp">Найти композиции композитора</option>
                        <option value="findartcomp">Найти композиции артиста</option>
                        <option value="findartgroup">Найти группы артиста</option>
                        <option value="findauthorcomp">Найти композиции автора</option>
                    </select>
                    <label>
                        <input type="text" name="inputField" value={this.state.inputField} onChange={this.handleInputChange} />
                    </label>
                    <input type="submit" value="Submit" />
                </form>
                <Albums data = {this.state.albums}/>
            </div>
        )
    }
}
function Album(props) {
    return <li>{props.albumName}</li>
}

function Albums(props) {

    return (

        <ul>{props.data.map((element, index) => <Album key={index} albumName={element}/>)}</ul>
    );
}
ReactDOM.render(<FindAlbumComposition/>, document.getElementById('findAlbums'));