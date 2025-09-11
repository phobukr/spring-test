package com.example.springtest.service;

import com.example.springtest.entity.Author;
import com.example.springtest.entity.Book;
import com.example.springtest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(@Valid Author author) {
        return authorRepository.save(author);
    }

    public Author read(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author update(@Valid Author author) {
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return authorRepository.findBooksByAuthorId(authorId);
    }

    public List<Author> getAuthorsByGenre(String genre) {
        return authorRepository.findByGenre(genre);
    }
}