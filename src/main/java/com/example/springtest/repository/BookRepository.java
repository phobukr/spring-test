package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springtest.model.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(Long id);

    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();
}