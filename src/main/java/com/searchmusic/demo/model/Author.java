package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = Author.FIND_ALL_COMPOS_AUTHOR, query = "select co.name from Author a left join " +
                "a.compositions co left join a.person p where lower(p.firstName)=?1 and lower(p.lastName) =?2"),

})
@Entity
@Table(name = "authors")
public class Author extends AbstractBaseEntity {
    public static final String FIND_ALL_COMPOS_AUTHOR = "Author.findAllCompositionAuthor";

    @OneToOne
    @JsonBackReference
    private Person person;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Composition> compositions;

    public Author() {
    }

    public Person getPerson() {
        return person;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", person=" + person +
                ", compositions=" + compositions +
                '}';
    }
}
