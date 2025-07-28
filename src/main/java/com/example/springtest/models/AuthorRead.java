package com.example.springtest.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AuthorRead {
    private Long id;
    
    @NotNull
    private String name;
    
    @Email
    private String email;

    public AuthorRead(Long id, String name, String email) {
        this.id = id;
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}