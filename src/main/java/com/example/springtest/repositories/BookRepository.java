package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.springtest.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByAuthorIdAndGenre(Integer authorId, String genre);
    List<Book> findByGenre(String genre);
}