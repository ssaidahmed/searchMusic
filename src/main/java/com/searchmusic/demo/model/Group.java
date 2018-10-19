package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "groups")
public class Group extends AbstractBaseEntity {


    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Album> albums;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "groups_artists", joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
        inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artists;

    @OneToMany
    @JoinColumn(name = "group_id")
    @JsonManagedReference
    private List<Composition> compositions;


    public Group() {
    }


    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    public List<Album> getAlbums() {
        return albums;
    }


    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                ", artists=" + artists +
                ", compositions=" + compositions +
                '}';
    }
}
