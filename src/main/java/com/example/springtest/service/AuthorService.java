package com.example.springtest.service;

import com.example.springtest.repository.AuthorRepository;
import com.example.springtest.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAuthorsByGenre(String genre) {
        return authorRepository.findAuthorsByGenre(genre);
    }
}