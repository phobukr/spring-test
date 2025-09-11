package com.example.springtest.controller;

import com.example.springtest.model.AuthorRead;
import com.example.springtest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorRead> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public AuthorRead createAuthor(@RequestBody AuthorRead author) {
        return authorService.createAuthor(author);
    }
}