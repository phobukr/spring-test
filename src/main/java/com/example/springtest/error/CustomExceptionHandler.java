package com.example.springtest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.Service;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@Service
public class BookService {

    public List<Book> getBooksByAuthorAndGenre(String author, String genre) {
        List<Book> books = findBooks(author, genre);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found for author: " + author + " and genre: " + genre);
        }
        return books;
    }

    private List<Book> findBooks(String author, String genre) {
        // Implementation to find books by author and genre
        return List.of(); // Placeholder for actual book retrieval logic
    }
}

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(@RequestParam String author, @RequestParam String genre) {
        List<Book> books = bookService.getBooksByAuthorAndGenre(author, genre);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class Book {
    // Book properties and methods
}