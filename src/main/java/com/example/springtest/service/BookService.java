package com.example.springtest.service;

import com.example.springtest.entity.Book;
import com.example.springtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        if (id == null) {
            throw new NullPointerException("Book ID cannot be null");
        }
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + id));
    }

    public Book createBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null");
        }
        if (book.getId() == null) {
            throw new NullPointerException("Book ID cannot be null");
        }
        Book existingBook = getBookById(book.getId());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        if (id == null) {
            throw new NullPointerException("Book ID cannot be null");
        }
        bookRepository.deleteById(id);
    }
}