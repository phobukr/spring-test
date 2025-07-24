package com.example.springtest.services;

import com.example.springtest.model.Book;
import com.example.springtest.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        Iterable<Book> books = bookService.getAllBooks();
        assertNotNull(books);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("Title", "Author");
        bookRepository.save(book);
        Book retrievedBook = bookService.getBookById(book.getId());
        assertNotNull(retrievedBook);
        assertEquals(book.getTitle(), retrievedBook.getTitle());
        assertEquals(book.getAuthor(), retrievedBook.getAuthor());
    }

    @Test
    public void testCreateBook() {
        Book book = new Book("Title", "Author");
        Book createdBook = bookService.createBook(book);
        assertNotNull(createdBook);
        assertEquals(book.getTitle(), createdBook.getTitle());
        assertEquals(book.getAuthor(), createdBook.getAuthor());
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("Title", "Author");
        bookRepository.save(book);
        book.setTitle("New Title");
        book.setAuthor("New Author");
        Book updatedBook = bookService.updateBook(book);
        assertNotNull(updatedBook);
        assertEquals(book.getTitle(), updatedBook.getTitle());
        assertEquals(book.getAuthor(), updatedBook.getAuthor());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Title", "Author");
        bookRepository.save(book);
        bookService.deleteBook(book.getId());
        assertEquals(0, bookRepository.count());
    }
}