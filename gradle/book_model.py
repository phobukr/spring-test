package book_model

"""
This module contains the definition of the Book class.
"""

class Book:
    """
    Represents a book in the system.

    Attributes:
        id (int): The unique identifier of the book.
        title (str): The title of the book.
        author_id (int): The identifier of the book's author.
        genre (str): The genre of the book.
    """

    def __init__(self, id: int, title: str, author_id: int, genre: str):
        """
        Initializes a Book object with the given attributes.

        Args:
            id (int): The unique identifier of the book.
            title (str): The title of the book.
            author_id (int): The identifier of the book's author.
            genre (str): The genre of the book.

        Raises:
            TypeError: If any of the input parameters are of the wrong type.
            ValueError: If any of the input parameters are invalid.
        """
        if not isinstance(id, int):
            raise TypeError("id must be an integer")
        if not isinstance(title, str):
            raise TypeError("title must be a string")
        if not isinstance(author_id, int):
            raise TypeError("author_id must be an integer")
        if not isinstance(genre, str):
            raise TypeError("genre must be a string")
        if id <= 0:
            raise ValueError("id must be a positive integer")
        if not title:
            raise ValueError("title cannot be empty")
        if author_id <= 0:
            raise ValueError("author_id must be a positive integer")
        if not genre:
            raise ValueError("genre cannot be empty")
        self.id = id
        self.title = title
        self.author_id = author_id
        self.genre = genre

    def __repr__(self):
        """
        Provides a string representation of the Book object.

        Returns:
            str: A string representation of the Book object.
        """
        return f"Book(id={self.id}, title='{self.title}', author_id={self.author_id}, genre='{self.genre}')"