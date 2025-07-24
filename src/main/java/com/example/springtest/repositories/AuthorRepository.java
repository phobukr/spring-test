package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springtest.models.Author;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByGenre(String genre);
}