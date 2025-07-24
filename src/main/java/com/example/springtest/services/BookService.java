package com.example.springtest.services;

import com.example.springtest.dto.BookRead;
import com.example.springtest.entities.Book;
import com.example.springtest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookRead> getBooksByAuthor(Integer authorId) {
        try {
            return bookRepository.findBooksByAuthor(authorId).stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author", e);
        }
    }

    public List<BookRead> getBooksByAuthorAndGenre(Integer authorId, String genre) {
        try {
            return bookRepository.findBooksByAuthorAndGenre(authorId, genre).stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author and genre", e);
        }
    }

    public List<BookRead> getBooksByGenre(String genre) {
        try {
            return bookRepository.findBooksByGenre(genre).stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by genre", e);
        }
    }

    private BookRead mapToBookRead(Book book) {
        BookRead bookRead = new BookRead();
        bookRead.setId(book.getId());
        bookRead.setTitle(book.getTitle());
        bookRead.setAuthor(book.getAuthor());
        return bookRead;
    }
}