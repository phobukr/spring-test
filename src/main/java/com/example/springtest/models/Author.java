package com.example.springtest.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "authors")
public class Author {
    
    @Id
    private Long id;
    
    private String name;
    
    private String biography;
    
    private String genre;

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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}