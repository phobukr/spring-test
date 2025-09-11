package com.example.springtest.controller;

import com.example.springtest.model.Author;
import com.example.springtest.model.Book;
import com.example.springtest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<Page<Author>> getAllAuthors(Pageable pageable) {
        Page<Author> authors = authorService.getAllAuthors(pageable);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        Author newAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId, @Valid @RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(authorId, author);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Long authorId) {
        try {
            authorService.deleteAuthor(authorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<Page<Book>> getBooksByAuthorId(@PathVariable Long authorId, Pageable pageable) {
        try {
            Page<Book> books = authorService.getBooksByAuthorId(authorId, pageable);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Author>> getAuthorsByGenre(@PathVariable String genre) {
        List<Author> authors = authorService.getAuthorsByGenre(genre);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}