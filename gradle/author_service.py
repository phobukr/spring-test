package gradle

import sqlite3
from sqlite3 import Error

class AuthorService:
    def __init__(self, db_file):
        self.conn = None
        try:
            self.conn = sqlite3.connect(db_file)
            print(sqlite3.version)
        except Error as e:
            print(e)

    def get_author_by_id(self, author_id):
        if not self.conn:
            raise Exception("Database connection is not established")
        if not isinstance(author_id, int) or author_id <= 0:
            raise ValueError("Invalid author ID")
        try:
            cur = self.conn.cursor()
            cur.execute("SELECT * FROM authors WHERE id=?", (author_id,))
            rows = cur.fetchall()
            for row in rows:
                return row
            return None
        except Error as e:
            print(e)
            return None

    def create_author(self, name, email):
        if not self.conn:
            raise Exception("Database connection is not established")
        if not isinstance(name, str) or not isinstance(email, str):
            raise ValueError("Invalid input parameters")
        try:
            cur = self.conn.cursor()
            cur.execute("INSERT INTO authors(name,email) VALUES(?,?)", (name, email))
            self.conn.commit()
            return cur.lastrowid
        except Error as e:
            print(e)
            return None

    def update_author(self, author_id, name, email):
        if not self.conn:
            raise Exception("Database connection is not established")
        if not isinstance(author_id, int) or author_id <= 0:
            raise ValueError("Invalid author ID")
        if not isinstance(name, str) or not isinstance(email, str):
            raise ValueError("Invalid input parameters")
        try:
            cur = self.conn.cursor()
            cur.execute("SELECT * FROM authors WHERE id=?", (author_id,))
            rows = cur.fetchall()
            if not rows:
                raise ValueError("Author does not exist")
            cur.execute("UPDATE authors SET name=?, email=? WHERE id=?", (name, email, author_id))
            self.conn.commit()
            return cur.rowcount
        except Error as e:
            print(e)
            return None

    def close_connection(self):
        if self.conn:
            self.conn.close()