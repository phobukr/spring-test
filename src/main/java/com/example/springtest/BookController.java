package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.springtest.models.BookRead;
import com.example.springtest.models.BookCreate;
import com.example.springtest.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookRead>> listBooks() {
        List<BookRead> books = bookService.listBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookRead> createBook(BookCreate bookCreate) {
        BookRead bookRead = bookService.createBook(bookCreate);
        return ResponseEntity.ok(bookRead);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookRead>> getBooksByAuthor(@PathVariable Long authorId) {
        List<BookRead> books = bookService.getBooksByAuthor(authorId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{authorId}/genre/{genre}")
    public ResponseEntity<List<BookRead>> getBooksByAuthorAndGenre(@PathVariable Long authorId, @PathVariable String genre) {
        List<BookRead> books = bookService.getBooksByAuthorAndGenre(authorId, genre);
        return ResponseEntity.ok(books);
    }
}