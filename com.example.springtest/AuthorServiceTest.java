package com.example.springtest;

import com.example.springtest.model.Author;
import com.example.springtest.repository.AuthorRepository;
import com.example.springtest.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testGetAuthor() {
        Author author = new Author("John Doe", "johndoe@example.com");
        authorRepository.save(author);
        Author retrievedAuthor = authorService.getAuthor(author.getId());
        assertNotNull(retrievedAuthor);
        assertEquals(author.getName(), retrievedAuthor.getName());
        assertEquals(author.getEmail(), retrievedAuthor.getEmail());
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author("Jane Doe", "janedoe@example.com");
        Author createdAuthor = authorService.createAuthor(author);
        assertNotNull(createdAuthor);
        assertEquals(author.getName(), createdAuthor.getName());
        assertEquals(author.getEmail(), createdAuthor.getEmail());
    }

    @Test
    public void testUpdateAuthor() {
        Author author = new Author("John Doe", "johndoe@example.com");
        authorRepository.save(author);
        Author updatedAuthor = new Author("John Doe Updated", "johndoeupdated@example.com");
        updatedAuthor.setId(author.getId());
        authorService.updateAuthor(updatedAuthor);
        Author retrievedAuthor = authorService.getAuthor(author.getId());
        assertNotNull(retrievedAuthor);
        assertEquals(updatedAuthor.getName(), retrievedAuthor.getName());
        assertEquals(updatedAuthor.getEmail(), retrievedAuthor.getEmail());
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author("John Doe", "johndoe@example.com");
        authorRepository.save(author);
        authorService.deleteAuthor(author.getId());
        Author retrievedAuthor = authorService.getAuthor(author.getId());
        assertEquals(null, retrievedAuthor);
    }
}