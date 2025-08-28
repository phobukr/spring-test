package com.example.springtest.db;

import org.sqlalchemy.Session;
import org.sqlalchemy.create_engine;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseSession {
    private static Session session;

    private static String getDatabaseUrl() {
        // Load database URL from a secure location
        Properties properties = new Properties();
        try (InputStream input = DatabaseSession.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
            return properties.getProperty("DATABASE_URL");
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database properties", e);
        }
    }

    private static String getUsername() {
        // Load username from a secure location
        Properties properties = new Properties();
        try (InputStream input = DatabaseSession.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
            return properties.getProperty("USERNAME");
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database properties", e);
        }
    }

    private static String getPassword() {
        // Load password from a secure location
        Properties properties = new Properties();
        try (InputStream input = DatabaseSession.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
            return properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database properties", e);
        }
    }

    public static Session get_db() {
        if (session == null) {
            String url = getDatabaseUrl();
            String username = getUsername();
            String password = getPassword();
            session = create_engine(url, username, password).connect();
        }
        return session;
    }

    public static void close_db() {
        if (session != null) {
            session.close();
            session = null;
        }
    }
}