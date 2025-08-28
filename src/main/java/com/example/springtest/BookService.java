package com.example.springtest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqlalchemy.Session;
import static org.sqlalchemy.and_;
import com.example.springtest.models.Book;
import com.example.springtest.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Retrieves a list of books by the specified author and genre.
     *
     * @param db       An instance of SQLAlchemy's Session for database interaction.
     * @param authorId An integer representing the unique identifier of the author.
     * @param genre    A string representing the genre of the books.
     * @return A list of Book entities matching the specified author and genre.
     */
    public List<Book> getBooksByAuthorAndGenre(Session db, int authorId, String genre) {
        if (authorId < 0) {
            throw new IllegalArgumentException("Author ID must be non-negative");
        }
        try {
            return db.createQuery("FROM Book WHERE authorId = :authorId AND genre = :genre", Book.class)
                     .setParameter("authorId", authorId)
                     .setParameter("genre", genre)
                     .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Database connection issue", e);
        }
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a list of books by the specified author.
     *
     * @param db       An instance of SQLAlchemy's Session for database interaction.
     * @param authorId An integer representing the unique identifier of the author.
     * @return A list of Book entities matching the specified author.
     */
    public List<Book> getBooksByAuthor(Session db, int authorId) {
        if (authorId < 0) {
            throw new IllegalArgumentException("Author ID must be non-negative");
        }
        try {
            return db.createQuery("FROM Book WHERE authorId = :authorId", Book.class)
                     .setParameter("authorId", authorId)
                     .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Database connection issue", e);
        }
    }
}