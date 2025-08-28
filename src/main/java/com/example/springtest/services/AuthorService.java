package com.example.springtest.services;

import org.hibernate.Session;
import com.example.springtest.models.Author;
import com.example.springtest.models.Book;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AuthorService {
    public List<Author> get_authors_by_genre(Session db, String genre) {
        CriteriaBuilder criteriaBuilder = db.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        criteriaQuery.select(bookRoot.get("author")).distinct(true)
                     .where(criteriaBuilder.equal(bookRoot.get("genre"), genre));
        return db.createQuery(criteriaQuery).getResultList();
    }
}