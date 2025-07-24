package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springtest.entities.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getBooksByAuthor(Long author_id);

    List<Book> getBooksByGenre(String genre);

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1 AND b.genre = ?2")
    List<Book> findByAuthorAndGenre(Long author_id, String genre);
}