package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = Artist.FIND_ALL_GROUP, query = "select g.name from Artist a left join " +
                "a.groups g left join a.person p where lower(p.firstName)=?1 and lower(p.lastName)=?2"),
        @NamedQuery(name = Artist.FIND_ALL_COMPOSITION, query = "select c.name from Artist a left join " +
                "a.compositions c left join a.person p where lower(p.firstName)=?1 and lower(p.lastName)=?2")
})
@Entity
@Table(name = "artists")
public class Artist extends AbstractBaseEntity{

    public static final String FIND_ALL_GROUP = "Artist.findAllGroupsWhereSangArtist";
    public static final String FIND_ALL_COMPOSITION = "Artist.findAllComposition";


    @OneToOne
    @JsonBackReference
    private Person person;

    @OneToOne(mappedBy = "artist")
    @JsonManagedReference
    private Album album;

    @ManyToMany(mappedBy = "artists")
    private List<Group> groups;
    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "artists_compositions", joinColumns = {@JoinColumn(name = "artist_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "composition_id", referencedColumnName = "id")})
    private List<Composition> compositions;

    public Artist() {
    }


    public Person getPerson() {
        return person;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Album getAlbum() {
        return album;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", person=" + person +
                ", album=" + album +
                ", groups=" + groups +
                ", compositions=" + compositions +
                '}';
    }
}
