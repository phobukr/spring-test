package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springtest.entities.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthorId(Long authorId);

    List<Book> findByGenre(String genre);

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1 AND b.genre = ?2")
    List<Book> findByAuthorIdAndGenre(Long authorId, String genre);
}