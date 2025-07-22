package com.example.springtest.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookCreate {
    @NotNull
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull
    @NotBlank(message = "Author is required")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}