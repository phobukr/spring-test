package com.example.springtest.crud;

import org.hibernate.Session;

public class AuthorCrud {
    public void create_author(Session db, AuthorCreate author) {
        db.beginTransaction();
        db.save(author);
        db.getTransaction().commit();
    }
}