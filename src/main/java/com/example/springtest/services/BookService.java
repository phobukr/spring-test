package com.example.springtest.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import com.example.springtest.models.Book;
import java.util.List;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    public Book createBook(BookCreate book) {
        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setGenre(book.getGenre());
        entityManager.persist(newBook);
        return newBook;
    }

    public List<Book> getBooksByGenre(Session db, String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre must not be null or empty");
        }
        return db.createQuery("FROM Book b WHERE b.genre = :genre", Book.class)
                 .setParameter("genre", genre)
                 .getResultList();
    }
}