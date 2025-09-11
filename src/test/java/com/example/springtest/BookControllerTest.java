package com.example.springtest;

import com.example.springtest.controller.BookController;
import com.example.springtest.model.Book;
import com.example.springtest.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book(1, "Book Title", "Author");
        when(bookService.getBookById(1)).thenReturn(book);
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Book Title"))
                .andExpect(jsonPath("$.author").value("Author"));
    }

    @Test
    public void testGetBookByIdNotFound() throws Exception {
        when(bookService.getBookById(1)).thenReturn(null);
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(
                new Book(1, "Book Title 1", "Author 1"),
                new Book(2, "Book Title 2", "Author 2")
        );
        when(bookService.getAllBooks()).thenReturn(books);
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Book Title 1"))
                .andExpect(jsonPath("$[0].author").value("Author 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Book Title 2"))
                .andExpect(jsonPath("$[1].author").value("Author 2"));
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(1, "Book Title", "Author");
        when(bookService.createBook(any(Book.class))).thenReturn(book);
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Book Title"))
                .andExpect(jsonPath("$.author").value("Author"));
    }

    @Test
    public void testCreateBookInvalidRequest() throws Exception {
        Book book = new Book(1, null, "Author");
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateBookServiceException() throws Exception {
        Book book = new Book(1, "Book Title", "Author");
        doThrow(new RuntimeException()).when(bookService).createBook(any(Book.class));
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetBookByIdServiceException() throws Exception {
        doThrow(new RuntimeException()).when(bookService).getBookById(1);
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetAllBooksServiceException() throws Exception {
        doThrow(new RuntimeException()).when(bookService).getAllBooks();
        mockMvc.perform(get("/books"))
                .andExpect(status().isInternalServerError());
    }
}