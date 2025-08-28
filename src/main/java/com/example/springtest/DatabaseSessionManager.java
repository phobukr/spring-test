package com.example.springtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
public class DatabaseSessionManager {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Session getDb() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session;
        } catch (Exception e) {
            throw new RuntimeException("Error opening session: " + e.getMessage(), e);
        }
    }
}