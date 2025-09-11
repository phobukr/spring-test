package com.example.springtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    private String author;

    @NotNull
    @Size(min = 1, max = 255)
    private String genre;

    @NotNull
    @Size(min = 1, max = 255)
    private String description;

    @NotNull
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author authorEntity;

    public Book() {}

    public Book(Long id, String title, String author, String genre, String description, Long authorId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.authorId = authorId;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Author getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(Author authorEntity) {
        this.authorEntity = authorEntity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + (title != null ? title : "") + '\'' +
                ", author='" + (author != null ? author : "") + '\'' +
                ", genre='" + (genre != null ? genre : "") + '\'' +
                ", description='" + (description != null ? description : "") + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}