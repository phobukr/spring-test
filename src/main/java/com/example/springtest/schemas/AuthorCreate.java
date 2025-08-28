package com.example.springtest.schemas;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorCreate {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    public AuthorCreate() {
    }

    public AuthorCreate(String name, String email) {
        this.name = name;
        this.email = email;
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