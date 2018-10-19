package com.searchmusic.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persons")
public class Person extends AbstractBaseEntity{

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;


    @OneToOne(mappedBy = "person")
    @JsonManagedReference
    private Artist artist;

    @OneToOne(mappedBy = "person")
    @JsonManagedReference
    private Composer composer;

    @OneToOne(mappedBy = "person")
    @JsonManagedReference
    private Author author;

    public Person() {
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", artist=" + artist +
                ", composer=" + composer +
                ", author=" + author +
                '}';
    }
}
