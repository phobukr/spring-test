package com.example.springtest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Optional;

@Component
public class GetDb implements AutoCloseable {

    private final SessionLocal sessionLocal;
    private Session session;

    @Autowired
    public GetDb(SessionLocal sessionLocal) {
        this.sessionLocal = sessionLocal;
    }

    public Session getDb() {
        session = sessionLocal.getCurrentSession();
        try {
            return session;
        } finally {
            // session will be closed when transaction is committed or rolled back
        }
    }

    @Override
    public void close() {
        if (session != null) {
            session.close();
        }
        TransactionSynchronizationManager.unbindResource(sessionLocal);
    }
}