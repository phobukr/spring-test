package com.example.springtest.repository;

import org.hibernate.Session;
import java.lang.ThreadLocal;

public class SessionLocal {
    private static ThreadLocal<Session> session = new ThreadLocal<>();

    public static void setSession(Session session) {
        SessionLocal.session.set(session);
    }

    public static Session getSession() {
        return session.get();
    }

    public static void removeSession() {
        session.remove();
    }
}