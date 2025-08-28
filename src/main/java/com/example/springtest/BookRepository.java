package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springtest.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}