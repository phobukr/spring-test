package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.springtest.models.AuthorCreate;
import com.example.springtest.models.AuthorRead;
import com.example.springtest.services.AuthorService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionScope;

@RestController
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors/")
    public ResponseEntity<AuthorRead> createAuthor(@RequestBody @Validated AuthorCreate authorCreate) {
        try {
            AuthorRead authorRead = authorService.createAuthor(authorCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body(authorRead);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/authors/")
    public ResponseEntity<List<AuthorRead>> listAuthors() {
        try {
            List<AuthorRead> authors = authorService.listAuthors();
            return ResponseEntity.ok(authors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/authors/genre/{genre}")
    public ResponseEntity<List<AuthorRead>> getAuthorsByGenre(@PathVariable String genre, @SessionScope Session session) {
        try {
            List<AuthorRead> authors = authorService.getAuthorsByGenre(genre, session);
            return ResponseEntity.ok(authors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}