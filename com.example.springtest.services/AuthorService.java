package com.example.springtest.services;

import com.example.springtest.models.Author;
import com.example.springtest.repositories.AuthorRepository;
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

    public List<Author> getAuthorsByGenre(String genre) {
        return authorRepository.findByGenre(genre);
    }
}