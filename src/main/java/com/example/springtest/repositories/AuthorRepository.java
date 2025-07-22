package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springtest.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}