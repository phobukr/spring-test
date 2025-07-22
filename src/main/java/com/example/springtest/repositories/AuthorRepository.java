package com.example.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.springtest.entities.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLastName(String lastName);
    
    @Query("SELECT a FROM Author a WHERE a.firstName = :firstName")
    List<Author> findByFirstName(@Param("firstName") String firstName);
    
    @Query("SELECT a FROM Author a WHERE a.lastName = :lastName AND a.firstName = :firstName")
    List<Author> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}