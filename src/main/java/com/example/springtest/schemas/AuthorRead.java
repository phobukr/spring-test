package com.example.springtest.schemas;

import javax.validation.constraints.NotNull;

public class AuthorRead {
    
    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String biography;

    private String email;

    public AuthorRead() {
    }

    public AuthorRead(Long id, String name, String biography, String email) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.email = email;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}