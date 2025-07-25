package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtest.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);
    Book findByAuthor(String author);
}