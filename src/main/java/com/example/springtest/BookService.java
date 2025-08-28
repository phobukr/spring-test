package com.example.springtest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import com.example.springtest.models.Book;
import static org.hibernate.criterion.Restrictions.and;

@Service
public class BookService {

    @Autowired
    private Session db;

    public List<Book> getBooksByAuthorAndGenre(Integer authorId, String genre) {
        String hql = "FROM Book b WHERE b.author_id = :authorId AND b.genre = :genre";
        Query<Book> query = db.createQuery(hql, Book.class);
        query.setParameter("authorId", authorId);
        query.setParameter("genre", genre);
        return query.list();
    }
}