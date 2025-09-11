package gradle

class Database:
    def __init__(self):
        self.books = {}
        self.authors = {}
        self.settings = {}

    def create_database(self):
        self.books = {}
        self.authors = {}

    def get_database_connection(self):
        return self

    def create_author(self, author):
        if author not in self.authors:
            self.authors[len(self.authors) + 1] = author
            return len(self.authors)
        else:
            raise Exception("Author already exists")

    def create_book(self, book):
        if book[0] not in [b[0] for b in self.books.values()]:
            self.books[len(self.books) + 1] = book
            return len(self.books)
        else:
            raise Exception("Book already exists")

    def get_all_authors(self):
        return list(self.authors.values())

    def get_all_books(self):
        return list(self.books.values())

    def get_author(self, id):
        if id in self.authors:
            return self.authors[id]
        else:
            raise Exception("Author not found")

    def get_book(self, id):
        if id in self.books:
            return self.books[id]
        else:
            raise Exception("Book not found")

    def update_author(self, author):
        for id, a in self.authors.items():
            if a == author[1]:
                self.authors[id] = author[0]
                break
        else:
            raise Exception("Author not found")

    def update_book(self, book):
        for id, b in self.books.items():
            if b[0] == book[0]:
                self.books[id] = book
                break
        else:
            raise Exception("Book not found")

    def delete_author(self, id):
        if id in self.authors:
            del self.authors[id]
        else:
            raise Exception("Author not found")

    def delete_book(self, id):
        if id in self.books:
            del self.books[id]
        else:
            raise Exception("Book not found")

    def filter_books_by_genre(self, genre):
        return [book for book in self.books.values() if book[2] == genre]

    def set_setting(self, key, value):
        self.settings[key] = value

    def get_setting(self, key):
        return self.settings.get(key)

def get_database_connection():
    return Database()

def main():
    database = get_database_connection()
    database.create_database()

    author_id = database.create_author("John Doe")
    print("Author ID:", author_id)

    book_id = database.create_book(("Book Title", author_id, "Fiction"))
    print("Book ID:", book_id)

    authors = database.get_all_authors()
    print("Authors:")
    for author in authors:
        print(author)

    books = database.get_all_books()
    print("Books:")
    for book in books:
        print(book)

    author = database.get_author(author_id)
    print("Author:", author)

    book = database.get_book(book_id)
    print("Book:", book)

    database.update_author(("Jane Doe", author_id))
    database.update_book(("Updated Book Title", author_id, "Non-Fiction"))

    database.delete_author(author_id)
    database.delete_book(book_id)

    books = database.filter_books_by_genre("Fiction")
    print("Books by Genre:")
    for book in books:
        print(book)

    database.set_setting("database_name", "my_database")
    print("Database Name:", database.get_setting("database_name"))

if __name__ == "__main__":
    main()