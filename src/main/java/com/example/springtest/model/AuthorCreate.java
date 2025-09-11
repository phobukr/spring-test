package com.example.springtest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorCreate {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}