package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.springtest.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorId(Integer authorId);
}