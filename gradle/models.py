package com.gradle.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.logging.Level

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @NotBlank
    val title: String,
    val description: String,
    @NotBlank
    val author: String,
    @NotNull
    @ManyToOne
    val genre: Genre
) {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Book::class.java)
    }

    fun updateTitle(newTitle: String) {
        this.title = newTitle
    }

    fun updateDescription(newDescription: String) {
        this.description = newDescription
    }

    fun updateAuthor(newAuthor: String) {
        this.author = newAuthor
    }

    fun updateGenre(newGenre: Genre) {
        this.genre = newGenre
    }
}

@Entity
data class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @NotBlank
    val name: String
) {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Genre::class.java)
    }

    fun updateName(newName: String) {
        this.name = newName
    }
}

interface BookRepository {
    fun findAll(): List<Book>
    fun findById(id: Long): Book?
    fun save(book: Book): Book
    fun update(book: Book): Book
    fun deleteById(id: Long)
}

interface GenreRepository {
    fun findAll(): List<Genre>
    fun findById(id: Long): Genre?
    fun save(genre: Genre): Genre
    fun update(genre: Genre): Genre
    fun deleteById(id: Long)
}

class BookRepositoryImpl : BookRepository {
    override fun findAll(): List<Book> {
        try {
            // implementation to fetch all books
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch all books", e)
        }
    }

    override fun findById(id: Long): Book? {
        try {
            // implementation to fetch book by id
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch book by id", e)
        }
    }

    override fun save(book: Book): Book {
        try {
            // implementation to save book
        } catch (e: Exception) {
            throw RuntimeException("Failed to save book", e)
        }
    }

    override fun update(book: Book): Book {
        try {
            // implementation to update book
        } catch (e: Exception) {
            throw RuntimeException("Failed to update book", e)
        }
    }

    override fun deleteById(id: Long) {
        try {
            // implementation to delete book by id
        } catch (e: Exception) {
            throw RuntimeException("Failed to delete book by id", e)
        }
    }
}

class GenreRepositoryImpl : GenreRepository {
    override fun findAll(): List<Genre> {
        try {
            // implementation to fetch all genres
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch all genres", e)
        }
    }

    override fun findById(id: Long): Genre? {
        try {
            // implementation to fetch genre by id
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch genre by id", e)
        }
    }

    override fun save(genre: Genre): Genre {
        try {
            // implementation to save genre
        } catch (e: Exception) {
            throw RuntimeException("Failed to save genre", e)
        }
    }

    override fun update(genre: Genre): Genre {
        try {
            // implementation to update genre
        } catch (e: Exception) {
            throw RuntimeException("Failed to update genre", e)
        }
    }

    override fun deleteById(id: Long) {
        try {
            // implementation to delete genre by id
        } catch (e: Exception) {
            throw RuntimeException("Failed to delete genre by id", e)
        }
    }
}

class BookService {
    private val bookRepository: BookRepository = BookRepositoryImpl()
    private val logger: Logger = LoggerFactory.getLogger(BookService::class.java)

    fun createBook(book: Book): Book {
        try {
            return bookRepository.save(book)
        } catch (e: Exception) {
            logger.error("Failed to create book", e)
            throw RuntimeException("Failed to create book", e)
        }
    }

    fun getBookById(id: Long): Book? {
        try {
            return bookRepository.findById(id)
        } catch (e: Exception) {
            logger.error("Failed to fetch book by id", e)
            throw RuntimeException("Failed to fetch book by id", e)
        }
    }

    fun updateBook(book: Book): Book {
        try {
            return bookRepository.update(book)
        } catch (e: Exception) {
            logger.error("Failed to update book", e)
            throw RuntimeException("Failed to update book", e)
        }
    }

    fun deleteBookById(id: Long) {
        try {
            bookRepository.deleteById(id)
        } catch (e: Exception) {
            logger.error("Failed to delete book by id", e)
            throw RuntimeException("Failed to delete book by id", e)
        }
    }
}

class GenreService {
    private val genreRepository: GenreRepository = GenreRepositoryImpl()
    private val logger: Logger = LoggerFactory.getLogger(GenreService::class.java)

    fun createGenre(genre: Genre): Genre {
        try {
            return genreRepository.save(genre)
        } catch (e: Exception) {
            logger.error("Failed to create genre", e)
            throw RuntimeException("Failed to create genre", e)
        }
    }

    fun getGenreById(id: Long): Genre? {
        try {
            return genreRepository.findById(id)
        } catch (e: Exception) {
            logger.error("Failed to fetch genre by id", e)
            throw RuntimeException("Failed to fetch genre by id", e)
        }
    }

    fun updateGenre(genre: Genre): Genre {
        try {
            return genreRepository.update(genre)
        } catch (e: Exception) {
            logger.error("Failed to update genre", e)
            throw RuntimeException("Failed to update genre", e)
        }
    }

    fun deleteGenreById(id: Long) {
        try {
            genreRepository.deleteById(id)
        } catch (e: Exception) {
            logger.error("Failed to delete genre by id", e)
            throw RuntimeException("Failed to delete genre by id", e)
        }
    }
}