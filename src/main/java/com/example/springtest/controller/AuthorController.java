package com.example.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.hibernate.Session;

@RestController
public class AuthorController {

    @Autowired
    private Session db;

    @PostMapping("/authors/")
    public AuthorRead create_author(@Valid @RequestBody AuthorCreate author) {
        return db.createAuthor(author);
    }
}