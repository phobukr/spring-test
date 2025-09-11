package python

from typing import List
from dataclasses import dataclass
from exceptions import NotFoundException, InvalidRequestException

@dataclass
class Book:
    id: int
    title: str
    author_id: int
    genre: str

class BookRepository:
    def get_books_by_author_and_genre(self, author_id: int, genre: str) -> List[Book]:
        books = [
            Book(1, "Book 1", 1, "Fiction"),
            Book(2, "Book 2", 1, "Non-Fiction"),
            Book(3, "Book 3", 2, "Fiction"),
            Book(4, "Book 4", 2, "Non-Fiction"),
        ]
        return [book for book in books if book.author_id == author_id and book.genre == genre]

class BookService:
    def __init__(self, book_repository: BookRepository):
        self.book_repository = book_repository

    def get_books_by_author_and_genre(self, author_id: int, genre: str) -> List[Book]:
        try:
            if not isinstance(author_id, int) or author_id <= 0:
                raise InvalidRequestException("Invalid author id")
            if not isinstance(genre, str) or len(genre.strip()) == 0:
                raise InvalidRequestException("Invalid genre")
            books = self.book_repository.get_books_by_author_and_genre(author_id, genre)
            if not books:
                raise NotFoundException("No books found for the given author and genre")
            return books
        except NotFoundException as e:
            raise NotFoundException("No books found for the given author and genre") from e
        except InvalidRequestException as e:
            raise InvalidRequestException("Invalid request") from e
        except Exception as e:
            raise NotFoundException("An error occurred while fetching books") from e