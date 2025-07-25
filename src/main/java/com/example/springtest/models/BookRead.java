package com.example.springtest.models;

import java.time.LocalDate;
import java.util.Objects;

public class BookRead {
    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public static BookRead fromBook(Book book) {
        BookRead bookRead = new BookRead();
        bookRead.setId(book.getId());
        bookRead.setTitle(book.getTitle());
        bookRead.setAuthor(book.getAuthor());
        bookRead.setPublicationDate(book.getPublicationDate());
        return bookRead;
    }
}