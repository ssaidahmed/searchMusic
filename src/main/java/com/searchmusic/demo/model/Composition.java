package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Composition.GET_ALL, query = "SELECT c.name, c.id FROM Composition c"),
        @NamedQuery(name = Composition.GET_ALL_ARTIST, query = "SELECT c.name, p.firstName, p.lastName FROM Composition c left join c.artists a join a.person p where c.id=?1"),
        @NamedQuery(name = Composition.GET_ALL_ALBUM, query = "SELECT a.name FROM Composition c left join c.albums a where lower(c.name)=?1")
})
//SELECT p.firstName, p.lastName FROM Composition c left join c.artists a join a.person p
@Entity
@Table(name = "compositions")
public class Composition extends AbstractBaseEntity {

    public static final String GET_ALL = "Composition.getAll";
    public static final String GET_ALL_ARTIST = "Composition.getAllArtist";
    public static final String GET_ALL_ALBUM = "Composition.getAllAlbum";

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    @ManyToOne
    @JoinColumn(name = "composer_id")
    @JsonBackReference
    private Composer composer;

    @ManyToMany(mappedBy = "compositions")
    @JsonBackReference
    private List<Album> albums;

    @ManyToMany(mappedBy = "compositions")
    @JsonBackReference
    private List<Artist> artists;


    private LocalDate dateOfCreation;


    public Composition() {
    }


    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Composer getComposer() {
        return composer;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", composer=" + composer +
                ", albums=" + albums +
                ", artists=" + artists +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
