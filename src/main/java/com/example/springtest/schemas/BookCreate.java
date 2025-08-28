package com.example.springtest.schemas;

import javax.validation.constraints.NotNull;

public class BookCreate {
    
    @NotNull
    private String title;
    
    @NotNull
    private String description;
    
    @NotNull
    private String genre;
    
    @NotNull
    private Long authorId;

    public BookCreate() {
    }

    public BookCreate(String title, String description, String genre, Long authorId) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}