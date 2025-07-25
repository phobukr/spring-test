package com.example.springtest;

import com.example.springtest.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetBooks() {
        var books = bookService.getBooks();
        assertNotNull(books);
        assertTrue(!books.isEmpty());
    }
}