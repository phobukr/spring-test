package com.example.springtest.service;

import com.example.springtest.dto.BookRead;
import com.example.springtest.entity.Book;
import com.example.springtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books", e);
        }
    }

    public Book createBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Error creating book", e);
        }
    }

    public Book getBookById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        try {
            return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving book by id", e);
        }
    }

    public List<BookRead> getBooksByAuthor(Long authorId) {
        if (authorId == null) {
            throw new IllegalArgumentException("Author id cannot be null");
        }
        try {
            return bookRepository.findByAuthorId(authorId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author", e);
        }
    }

    public List<Book> getBooksByAuthorAndGenre(Long authorId, String genre) {
        if (authorId == null) {
            throw new IllegalArgumentException("Author id cannot be null");
        }
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
        try {
            return bookRepository.findByAuthorIdAndGenre(authorId, genre);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author and genre", e);
        }
    }

    public List<Book> getBooksByGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
        try {
            return bookRepository.findByGenre(genre);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by genre", e);
        }
    }
}