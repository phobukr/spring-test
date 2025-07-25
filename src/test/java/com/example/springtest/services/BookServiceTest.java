package com.example.springtest.services;

import com.example.springtest.model.Book;
import com.example.springtest.model.Genre;
import com.example.springtest.repository.BookRepository;
import com.example.springtest.services.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testGetBooksByGenre() {
        // Given
        Genre genre = new Genre("Test Genre");
        Book book1 = new Book("Test Book 1", genre);
        Book book2 = new Book("Test Book 2", genre);
        Book book3 = new Book("Test Book 3", new Genre("Other Genre"));

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        // When
        List<Book> books = bookService.getBooksByGenre(genre.getName());

        // Then
        assertNotNull(books);
        assertEquals(2, books.size());
        assertEquals(book1.getTitle(), books.get(0).getTitle());
        assertEquals(book2.getTitle(), books.get(1).getTitle());
    }

    @Test
    public void testGetBooksByGenreEmptyList() {
        // Given
        Genre genre = new Genre("Test Genre");
        Book book1 = new Book("Test Book 1", new Genre("Other Genre"));

        bookRepository.save(book1);

        // When
        List<Book> books = bookService.getBooksByGenre(genre.getName());

        // Then
        assertNotNull(books);
        assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByGenreNull() {
        // When
        List<Book> books = bookService.getBooksByGenre(null);

        // Then
        assertNotNull(books);
        assertEquals(0, books.size());
    }
}