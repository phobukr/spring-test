package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.springtest.models.BookRead;
import com.example.springtest.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookRead>> getBooksByAuthor(@PathVariable Integer authorId) {
        if (authorId == null || authorId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<BookRead> books = bookService.getBooksByAuthor(authorId);
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}