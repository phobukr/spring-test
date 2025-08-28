package com.example.springtest.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRouter {

    @GetMapping
    public List<String> listBooks() {
        return List.of("Book 1", "Book 2", "Book 3");
    }
}