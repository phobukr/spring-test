package com.example.springtest.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthorCreate {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(max = 200)
    private String biography;

    public AuthorCreate() {
    }

    public AuthorCreate(String name, String biography) {
        this.name = name;
        this.biography = biography;
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
}