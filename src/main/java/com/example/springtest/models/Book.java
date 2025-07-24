package com.example.springtest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Author author;
    private LocalDate publicationDate;
    private String publisher;
    private Integer numberOfPages;
    private String isbn;
    private String genre;

    public Book() {}

    public Book(String title, String author, LocalDate publicationDate, String publisher, Integer numberOfPages, String isbn) {
        this.title = title;
        this.author = new Author(author);
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
    }

    public Book(String title, String author, LocalDate publicationDate, String publisher, Integer numberOfPages, String isbn, String genre) {
        this.title = title;
        this.author = new Author(author);
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Book(String title, Author author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publicationDate=" + publicationDate +
                ", publisher='" + publisher + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}