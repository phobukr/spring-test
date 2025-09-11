package com.example.springtest.doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Book endpoint documentation.
 *
 * This class provides clear and concise descriptions of the request and response formats,
 * as well as any error messages that may be returned.
 *
 * @author [Your Name]
 * @version 1.0
 */
@Api(value = "book", description = "Book endpoint")
@RestController
@RequestMapping("/api/books")
public class BookEndpointDocumentation {

    private final BookService bookService;

    @Autowired
    public BookEndpointDocumentation(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Get all books.
     *
     * @return List of books
     */
    @ApiOperation(value = "Get all books", notes = "Returns a list of all books")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Books found"),
            @ApiResponse(code = 404, message = "No books found")
    })
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(books);
    }

    /**
     * Get book by id.
     *
     * @param id Book id
     * @return Book
     */
    @ApiOperation(value = "Get book by id", notes = "Returns a book by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book found"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @ApiParam(value = "Book id", required = true) @PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Create a new book.
     *
     * @param book Book
     * @return Created book
     */
    @ApiOperation(value = "Create a new book", notes = "Creates a new book")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book created"),
            @ApiResponse(code = 400, message = "Invalid book data")
    })
    @PostMapping
    public ResponseEntity<Book> createBook(
            @ApiParam(value = "Book data", required = true) @RequestBody Book book) {
        try {
            Book createdBook = bookService.createBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Update an existing book.
     *
     * @param id   Book id
     * @param book Book
     * @return Updated book
     */
    @ApiOperation(value = "Update an existing book", notes = "Updates an existing book")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book updated"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @ApiParam(value = "Book id", required = true) @PathVariable Long id,
            @ApiParam(value = "Book data", required = true) @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Delete a book.
     *
     * @param id Book id
     * @return Deleted book
     */
    @ApiOperation(value = "Delete a book", notes = "Deletes a book")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book deleted"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(
            @ApiParam(value = "Book id", required = true) @PathVariable Long id) {
        try {
            Book deletedBook = bookService.deleteBook(id);
            return ResponseEntity.ok(deletedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

class Book {
    private Long id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    Book deleteBook(Long id);
}

class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
        return book;
    }
}

interface BookRepository extends org.springframework.data.repository.CrudRepository<Book, Long> {
}