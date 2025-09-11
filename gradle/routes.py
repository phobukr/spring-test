package routes

from flask import Blueprint, request, jsonify
from database import db
from flask_paginate import Pagination, get_page_args

app = Blueprint('routes', __name__)

MAX_PER_PAGE = 100

@app.route('/books/genre/<genre>', methods=['GET'])
def get_books_by_genre(genre):
    page, per_page, offset = get_page_args(page_parameter='page', per_page_parameter='limit')
    try:
        page = int(page)
        per_page = int(per_page)
    except ValueError:
        return jsonify({'error': 'Invalid page or limit parameter'}), 400

    if page < 1 or per_page < 1 or per_page > MAX_PER_PAGE:
        return jsonify({'error': 'Invalid page or limit parameter'}), 400

    valid_genres = db.get_valid_genres()
    if genre not in valid_genres:
        return jsonify({'error': 'Invalid genre parameter'}), 400

    try:
        books = db.filter_by_genre(genre, offset, per_page)
        total_books = db.get_all_books_by_genre(genre)
        pagination = Pagination(page=page, per_page=per_page, total=len(total_books), record_name='books')
        return jsonify({
            'books': books,
            'pagination': {
                'page': page,
                'per_page': per_page,
                'total': len(total_books)
            }
        })
    except Exception as e:
        return jsonify({'error': 'Failed to retrieve books'}), 500