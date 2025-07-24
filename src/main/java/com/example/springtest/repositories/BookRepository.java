package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springtest.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Integer authorId);

    @Query("SELECT b FROM Book b WHERE b.author.id = :authorId AND b.genre = :genre")
    List<Book> findByAuthorIdAndGenre(@Param("authorId") Integer authorId, @Param("genre") String genre);

    List<Book> findByGenre(String genre);
}