package com.example.springtest;

import com.example.springtest.controller.BookController;
import com.example.springtest.model.Book;
import com.example.springtest.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        assertNotNull(bookController.getAllBooks());
    }

    @Test
    public void testGetBookById() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        bookRepository.save(book);
        assertNotNull(bookController.getBookById(book.getId()));
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        assertNotNull(bookController.createBook(book));
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        bookRepository.save(book);
        book.setTitle("Updated Test Book");
        assertNotNull(bookController.updateBook(book));
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        bookRepository.save(book);
        bookController.deleteBook(book.getId());
        assertNull(bookRepository.findById(book.getId()));
    }
}