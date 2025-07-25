package com.example.springtest.services;

import com.example.springtest.dto.BookCreate;
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

    public List<BookRead> retrieveBooks() {
        try {
            return bookRepository.findAll().stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books", e);
        }
    }

    public BookRead createBook(BookCreate bookCreate) {
        try {
            Book book = new Book();
            book.setTitle(bookCreate.getTitle());
            book.setAuthor(bookCreate.getAuthor());
            book = bookRepository.save(book);
            return mapToBookRead(book);
        } catch (Exception e) {
            throw new RuntimeException("Error creating book", e);
        }
    }

    private BookRead mapToBookRead(Book book) {
        BookRead bookRead = new BookRead();
        bookRead.setId(book.getId());
        bookRead.setTitle(book.getTitle());
        bookRead.setAuthor(book.getAuthor());
        return bookRead;
    }

    public List<BookRead> listBooks(String title, String author) {
        try {
            List<Book> books = bookRepository.findAll();
            return books.stream()
                    .filter(book -> (title == null || book.getTitle().contains(title))
                            && (author == null || book.getAuthor().contains(author)))
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error listing books", e);
        }
    }

    public List<BookRead> listBooks() {
        try {
            return bookRepository.findAll().stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error listing books", e);
        }
    }

    public BookRead getBook(Long id) {
        try {
            Book book = bookRepository.findById(id).orElseThrow();
            return mapToBookRead(book);
        } catch (Exception e) {
            throw new RuntimeException("Error getting book", e);
        }
    }

    public List<BookRead> getBooks() {
        try {
            return bookRepository.findAll().stream()
                    .map(this::mapToBookRead)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error getting books", e);
        }
    }
}