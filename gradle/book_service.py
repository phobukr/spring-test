package book_service

import sqlite3
from sqlite3 import Error

class BookService:
    def __init__(self, db_file):
        """
        Initialize the BookService class.

        Args:
            db_file (str): The path to the SQLite database file.
        """
        self.conn = None
        try:
            self.conn = sqlite3.connect(db_file)
            print(sqlite3.version)
        except Error as e:
            print(e)

    def get_book_by_id(self, book_id):
        """
        Retrieve a book by its ID.

        Args:
            book_id (int): The ID of the book to retrieve.

        Returns:
            tuple: The book data if found, otherwise None.
        """
        try:
            cur = self.conn.cursor()
            cur.execute("SELECT * FROM books WHERE id=?", (book_id,))
            rows = cur.fetchall()
            for row in rows:
                return row
            return None
        except Error as e:
            print(f"Error retrieving book: {e}")
            return None

    def create_book(self, title, author, publication_date):
        """
        Create a new book.

        Args:
            title (str): The title of the book.
            author (str): The author of the book.
            publication_date (str): The publication date of the book.

        Returns:
            int: The ID of the newly created book.
        """
        try:
            if not title or not author or not publication_date:
                raise ValueError("All fields are required")
            cur = self.conn.cursor()
            cur.execute("INSERT INTO books(title,author,publication_date) VALUES(?,?,?)", (title, author, publication_date))
            self.conn.commit()
            return cur.lastrowid
        except Error as e:
            print(f"Error creating book: {e}")
            return None
        except ValueError as e:
            print(f"Error creating book: {e}")
            return None

    def update_book(self, book_id, title, author, publication_date):
        """
        Update an existing book.

        Args:
            book_id (int): The ID of the book to update.
            title (str): The new title of the book.
            author (str): The new author of the book.
            publication_date (str): The new publication date of the book.

        Returns:
            int: The number of rows updated.
        """
        try:
            if not title or not author or not publication_date:
                raise ValueError("All fields are required")
            cur = self.conn.cursor()
            cur.execute("UPDATE books SET title=?, author=?, publication_date=? WHERE id=?", (title, author, publication_date, book_id))
            self.conn.commit()
            return cur.rowcount
        except Error as e:
            print(f"Error updating book: {e}")
            return None
        except ValueError as e:
            print(f"Error updating book: {e}")
            return None

    def close_connection(self):
        """
        Close the database connection.
        """
        if self.conn:
            self.conn.close()