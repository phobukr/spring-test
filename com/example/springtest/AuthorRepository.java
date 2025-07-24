package com.example.springtest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> findAuthorsByGenre(String genre) {
        Query query = entityManager.createQuery("SELECT a FROM Author a WHERE a.genre = :genre");
        query.setParameter("genre", genre);
        return query.getResultList();
    }
}