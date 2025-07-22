package com.example.springtest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springtest.models.AuthorCreate;
import com.example.springtest.models.AuthorRead;
import com.example.springtest.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public AuthorRead createAuthor(AuthorCreate authorCreate) {
        Author author = new Author();
        author.setName(authorCreate.getName());
        author.setBio(authorCreate.getBio());
        try {
            author = authorRepository.save(author);
        } catch (Exception e) {
            logger.error("Error creating author: {}", e.getMessage());
            throw e;
        }
        return new AuthorRead(author.getId(), author.getName(), author.getBio());
    }

    public List<Author> getAuthors() {
        try {
            return authorRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving authors: {}", e.getMessage());
            return List.of();
        }
    }
}