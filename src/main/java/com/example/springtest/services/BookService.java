package com.example.springtest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springtest.repositories.BookRepository;
import com.example.springtest.models.BookRead;
import com.example.springtest.models.Book;
import org.springframework.dao.DataAccessException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookRead> getBooksByAuthor(Integer authorId) {
        try {
            List<Book> books = bookRepository.findByAuthorId(authorId);
            return books.stream()
                        .map(book -> new BookRead(book.getId(), book.getTitle(), book.getAuthorId()))
                        .toList();
        } catch (DataAccessException e) {
            throw new RuntimeException("Database access error while retrieving books for authorId: " + authorId, e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while retrieving books for authorId: " + authorId, e);
        }
    }
}