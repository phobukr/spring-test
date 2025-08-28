package com.example.springtest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import com.example.springtest.models.Author;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private Session db;

    public List<Author> getAuthors() {
        return db.createQuery("FROM Author", Author.class).list();
    }
}