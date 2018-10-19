package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album extends AbstractBaseEntity{


    private String name;
    @OneToOne
    @JsonBackReference
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Group group;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "albums_compositions", joinColumns = {@JoinColumn(name = "album_id", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "composition_id", referencedColumnName = "id"))
    private List<Composition> compositions;

    private LocalDate dateOfCreation;

    public Album() {
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public Group getGroup() {
        return group;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", group=" + group +
                ", compositions=" + compositions +
                '}';
    }
}
