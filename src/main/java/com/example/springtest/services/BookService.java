package com.example.springtest.services;

import com.example.springtest.dto.BookCreate;
import com.example.springtest.dto.BookRead;
import com.example.springtest.entities.Book;
import com.example.springtest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> retrieveBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books", e);
        }
    }

    public Book createBook(BookCreate bookCreate) {
        try {
            if (bookCreate.getTitle() == null || bookCreate.getAuthor() == null) {
                throw new RuntimeException("Title and author are required");
            }
            Book book = new Book();
            book.setTitle(bookCreate.getTitle());
            book.setAuthor(bookCreate.getAuthor());
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Error creating book", e);
        }
    }

    public List<Book> getBooksByAuthor(Integer authorId) {
        try {
            if (authorId == null) {
                throw new RuntimeException("Author ID is required");
            }
            return bookRepository.findByAuthorId(authorId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author", e);
        }
    }

    public List<Book> getBooksByAuthorAndGenre(Integer authorId, String genre) {
        try {
            if (authorId == null || genre == null) {
                throw new RuntimeException("Author ID and genre are required");
            }
            return entityManager.createQuery("SELECT b FROM Book b WHERE b.author.id = :authorId AND b.genre = :genre")
                    .setParameter("authorId", authorId)
                    .setParameter("genre", genre)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by author and genre", e);
        }
    }

    public List<Book> getBooksByGenre(String genre) {
        try {
            if (genre == null) {
                throw new RuntimeException("Genre is required");
            }
            return bookRepository.findByGenre(genre);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books by genre", e);
        }
    }

    private BookRead mapToBookRead(Book book) {
        BookRead bookRead = new BookRead();
        bookRead.setId(book.getId());
        bookRead.setTitle(book.getTitle());
        bookRead.setAuthor(book.getAuthor());
        return bookRead;
    }
}