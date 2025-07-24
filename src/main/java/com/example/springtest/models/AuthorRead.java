package com.example.springtest.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorRead {
    @Id
    private Long id;
    
    private String name;
    
    private String genre;

    public AuthorRead(Long id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}