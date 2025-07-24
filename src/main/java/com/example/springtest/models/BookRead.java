package com.example.springtest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookRead {
    @Id
    private Integer id;
    private String title;
    private String authorName;
    private String genre;
    private LocalDate publicationDate;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRead)) return false;
        BookRead bookRead = (BookRead) o;
        return Objects.equals(id, bookRead.id) &&
                Objects.equals(title, bookRead.title) &&
                Objects.equals(authorName, bookRead.authorName) &&
                Objects.equals(genre, bookRead.genre) &&
                Objects.equals(publicationDate, bookRead.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorName, genre, publicationDate);
    }
}