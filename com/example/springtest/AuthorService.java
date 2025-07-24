package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthorsByGenre(String genre) {
        return authorRepository.findAll().stream()
                .filter(author -> author.getGenre().equals(genre))
                .collect(Collectors.toList());
    }
}