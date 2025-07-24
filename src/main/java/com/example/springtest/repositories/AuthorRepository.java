package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.springtest.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByGenre(String genre);
}