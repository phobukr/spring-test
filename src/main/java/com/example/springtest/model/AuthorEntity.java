package com.example.springtest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents the author data model.
 */
@Entity
@Table(name = "authors")
public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Size(max = 1000)
    @Column(name = "biography")
    private String biography;

    public AuthorEntity() {
    }

    public AuthorEntity(Long id, String name, String surname, Date dateOfBirth, String biography) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + (id != null ? id : "null") +
                ", name='" + (name != null ? name : "null") + '\'' +
                ", surname='" + (surname != null ? surname : "null") + '\'' +
                ", dateOfBirth=" + (dateOfBirth != null ? dateOfBirth : "null") +
                ", biography='" + (biography != null ? biography : "null") + '\'' +
                '}';
    }
}