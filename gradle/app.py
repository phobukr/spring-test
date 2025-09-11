package app

from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///author_book.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.config['DEBUG'] = True

db = SQLAlchemy(app)
ma = Marshmallow(app)

class Author(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    books = db.relationship('Book', backref='author', lazy=True)

class Book(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(100), nullable=False)
    author_id = db.Column(db.Integer, db.ForeignKey('author.id'), nullable=False)

class AuthorSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Author
        load_instance = True

class BookSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Book
        load_instance = True

author_schema = AuthorSchema()
authors_schema = AuthorSchema(many=True)
book_schema = BookSchema()
books_schema = BookSchema(many=True)

class AuthorBookApp:
    def __init__(self, app):
        self.app = app
        self.app.route('/authors', methods=['GET'])(self.get_authors)
        self.app.route('/authors/<id>', methods=['GET'])(self.get_author)
        self.app.route('/authors', methods=['POST'])(self.create_author)
        self.app.route('/authors/<id>', methods=['PUT'])(self.update_author)
        self.app.route('/authors/<id>', methods=['DELETE'])(self.delete_author)
        self.app.route('/books', methods=['GET'])(self.get_books)
        self.app.route('/books/<id>', methods=['GET'])(self.get_book)
        self.app.route('/books', methods=['POST'])(self.create_book)
        self.app.route('/books/<id>', methods=['PUT'])(self.update_book)
        self.app.route('/books/<id>', methods=['DELETE'])(self.delete_book)
        self.app.errorhandler(404)(self.not_found)
        self.app.errorhandler(500)(self.server_error)

    def get_authors(self):
        try:
            authors = Author.query.all()
            return jsonify(authors_schema.dump(authors))
        except Exception as e:
            return jsonify({'message': 'Error fetching authors'}), 500

    def get_author(self, id):
        try:
            author = Author.query.get(id)
            if author is None:
                return jsonify({'message': 'Author not found'}), 404
            return jsonify(author_schema.dump(author))
        except Exception as e:
            return jsonify({'message': 'Error fetching author'}), 500

    def create_author(self):
        try:
            data = request.get_json()
            if 'name' not in data:
                return jsonify({'message': 'Name is required'}), 400
            author = Author(name=data['name'])
            db.session.add(author)
            db.session.commit()
            return jsonify(author_schema.dump(author))
        except Exception as e:
            return jsonify({'message': 'Error creating author'}), 500

    def update_author(self, id):
        try:
            author = Author.query.get(id)
            if author is None:
                return jsonify({'message': 'Author not found'}), 404
            data = request.get_json()
            if 'name' not in data:
                return jsonify({'message': 'Name is required'}), 400
            author.name = data['name']
            db.session.commit()
            return jsonify(author_schema.dump(author))
        except Exception as e:
            return jsonify({'message': 'Error updating author'}), 500

    def delete_author(self, id):
        try:
            author = Author.query.get(id)
            if author is None:
                return jsonify({'message': 'Author not found'}), 404
            db.session.delete(author)
            db.session.commit()
            return jsonify({'message': 'Author deleted'})
        except Exception as e:
            return jsonify({'message': 'Error deleting author'}), 500

    def get_books(self):
        try:
            books = Book.query.all()
            return jsonify(books_schema.dump(books))
        except Exception as e:
            return jsonify({'message': 'Error fetching books'}), 500

    def get_book(self, id):
        try:
            book = Book.query.get(id)
            if book is None:
                return jsonify({'message': 'Book not found'}), 404
            return jsonify(book_schema.dump(book))
        except Exception as e:
            return jsonify({'message': 'Error fetching book'}), 500

    def create_book(self):
        try:
            data = request.get_json()
            if 'title' not in data or 'author_id' not in data:
                return jsonify({'message': 'Title and author_id are required'}), 400
            book = Book(title=data['title'], author_id=data['author_id'])
            db.session.add(book)
            db.session.commit()
            return jsonify(book_schema.dump(book))
        except Exception as e:
            return jsonify({'message': 'Error creating book'}), 500

    def update_book(self, id):
        try:
            book = Book.query.get(id)
            if book is None:
                return jsonify({'message': 'Book not found'}), 404
            data = request.get_json()
            if 'title' not in data or 'author_id' not in data:
                return jsonify({'message': 'Title and author_id are required'}), 400
            book.title = data['title']
            book.author_id = data['author_id']
            db.session.commit()
            return jsonify(book_schema.dump(book))
        except Exception as e:
            return jsonify({'message': 'Error updating book'}), 500

    def delete_book(self, id):
        try:
            book = Book.query.get(id)
            if book is None:
                return jsonify({'message': 'Book not found'}), 404
            db.session.delete(book)
            db.session.commit()
            return jsonify({'message': 'Book deleted'})
        except Exception as e:
            return jsonify({'message': 'Error deleting book'}), 500

    def not_found(self, e):
        return jsonify({'message': 'Not found'}), 404

    def server_error(self, e):
        return jsonify({'message': 'Internal server error'}), 500

if __name__ == '__main__':
    db.create_all()
    AuthorBookApp(app)
    app.run()