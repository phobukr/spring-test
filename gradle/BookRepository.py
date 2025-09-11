package gradle

import sqlite3
from typing import List, Dict

class BookRepository:
    def __init__(self):
        self.data_storage = {
            1: {"id": 1, "author_id": 1, "genre": "Fiction", "title": "Book1"},
            2: {"id": 2, "author_id": 1, "genre": "Non-Fiction", "title": "Book2"},
            3: {"id": 3, "author_id": 2, "genre": "Fiction", "title": "Book3"}
        }

    def get_books_by_author_and_genre(self, author_id: int, genre: str) -> List[Dict]:
        try:
            if not isinstance(author_id, int) or not isinstance(genre, str):
                return [{"error": "Invalid input type"}]
            if author_id <= 0:
                return [{"error": "Author ID must be a positive integer"}]
            if not genre:
                return [{"error": "Genre cannot be empty"}]
            books = [book for book in self.data_storage.values() if book["author_id"] == author_id and book["genre"] == genre]
            if not books:
                return [{"error": "Author or genre not found"}]
            return books
        except Exception as e:
            return [{"error": str(e)}]