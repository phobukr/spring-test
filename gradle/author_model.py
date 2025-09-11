package com.gradle

class Author:
    def __init__(self, id, name, books=None):
        self.id = id
        self.name = name
        self.books = books if books is not None else []

    def __repr__(self):
        return f"Author(id={self.id}, name='{self.name}', books={self.books})"