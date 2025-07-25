package com.example.springtest.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AuthorRead {
    private Long id;
    
    @NotNull
    private String name;
    
    @Email
    private String email;
    private String genre;

    public AuthorRead(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public AuthorRead(Long id, String name, String email, String genre) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}