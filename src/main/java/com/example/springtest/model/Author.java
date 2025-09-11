package com.example.springtest.model;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {

    private Long id;
    private String name;
    private List<String> books;

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

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}