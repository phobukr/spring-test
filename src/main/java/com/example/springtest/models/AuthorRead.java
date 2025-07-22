package com.example.springtest.models;

import java.util.List;
import com.example.springtest.models.Author;

public class AuthorRead {
    private Long id;
    
    private String name;
    
    private String email;
    private List<String> genre;

    public AuthorRead(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public AuthorRead(Long id, String name, String email, List<String> genre) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}