package 

class Book:
    def __init__(self, id, title, author_id, genre):
        self.__id = id
        self.__title = title
        self.__author_id = author_id
        self.__genre = genre

    def get_id(self):
        return self.__id

    def set_id(self, id):
        if not isinstance(id, int) or id < 0:
            raise ValueError("Id must be a non-negative integer")
        self.__id = id

    def get_title(self):
        return self.__title

    def set_title(self, title):
        if not isinstance(title, str) or len(title) == 0:
            raise ValueError("Title must be a non-empty string")
        self.__title = title

    def get_author_id(self):
        return self.__author_id

    def set_author_id(self, author_id):
        if not isinstance(author_id, int) or author_id < 0:
            raise ValueError("Author id must be a non-negative integer")
        self.__author_id = author_id

    def get_genre(self):
        return self.__genre

    def set_genre(self, genre):
        if not isinstance(genre, str) or len(genre) == 0:
            raise ValueError("Genre must be a non-empty string")
        self.__genre = genre