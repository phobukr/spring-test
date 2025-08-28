package com.example.springtest.crud;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookCRUD {

    public List<Book> getBooks(Session session) {
        Query<Book> query = session.createQuery("FROM Book", Book.class);
        return query.getResultList();
    }
}