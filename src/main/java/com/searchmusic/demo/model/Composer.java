package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = Composer.FIND_ALL_COMPOS_COMPOSER, query = "select co.name from Composer c left join " +
                "c.compositions co left join c.person p where LOWER(p.firstName) =?1 and lower(p.lastName) =?2"),

})
@Entity
@Table(name = "composers")
public class Composer extends AbstractBaseEntity{

    public static final String FIND_ALL_COMPOS_COMPOSER = "Composer.findAllCompositionComposer";

    @OneToOne
    @JsonBackReference
    private Person person;

    @OneToMany(mappedBy = "composer")
    @JsonManagedReference
    private List<Composition> compositions;

    public Composer() {
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
        return "Composer{" +
                "id=" + id +
                ", person=" + person +
                ", compositions=" + compositions +
                '}';
    }
}
