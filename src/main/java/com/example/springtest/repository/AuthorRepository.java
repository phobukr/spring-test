package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtest.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    java.util.List<Author> findByGenre(String genre);
}