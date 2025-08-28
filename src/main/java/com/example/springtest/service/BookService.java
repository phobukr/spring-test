package com.example.springtest.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import com.example.springtest.model.Book;
import static org.hibernate.criterion.Restrictions.and;

import java.util.List;

@Service
public class BookService {

    public List<Book> getBooksByAuthorAndGenre(Session db, int authorId, String genre) {
        if (authorId <= 0 || genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Invalid authorId or genre");
        }
        try {
            Query<Book> query = db.createQuery("FROM Book WHERE authorId = :authorId AND genre = :genre", Book.class);
            query.setParameter("authorId", authorId);
            query.setParameter("genre", genre);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Database error occurred", e);
        }
    }
}