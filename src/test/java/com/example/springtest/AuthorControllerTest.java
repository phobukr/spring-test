package com.example.springtest;

import com.example.springtest.controller.AuthorController;
import com.example.springtest.model.Author;
import com.example.springtest.model.Genre;
import com.example.springtest.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AuthorRepository authorRepository;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        authorRepository.deleteAll();
    }

    @Test
    public void testGetAuthorsByGenre() throws Exception {
        Genre genre = new Genre("Test Genre");
        Author author1 = new Author("Author 1", genre);
        Author author2 = new Author("Author 2", genre);
        Author author3 = new Author("Author 3", new Genre("Different Genre"));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));

        mockMvc.perform(MockMvcRequestBuilders.get("/authors/genre/" + genre.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}