package com.example.springtest.controllers;

import com.example.springtest.models.Book;
import com.example.springtest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET, params = "genre")
    public List<Book> getBooksByGenre(@RequestParam("genre") String genre) {
        try {
            return bookService.getBooksByGenre(genre);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by genre", e);
        }
    }
}