package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.example.springtest.entities.Book;
import com.example.springtest.entities.Author;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthorId(Long authorId);

    List<Book> findBooksByAuthorAndGenre(Long authorId, String genre);

    List<Book> findByGenre(String genre);
}