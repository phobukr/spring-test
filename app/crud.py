from sqlalchemy.orm import Session
from sqlalchemy import and_
from app import models, schemas

def create_author(db: Session, author: schemas.AuthorCreate):
    db_author = models.Author(name=author.name)
    db.add(db_author)
    db.commit()
    db.refresh(db_author)
    return db_author

def get_authors(db: Session):
    return db.query(models.Author).all()

def create_book(db: Session, book: schemas.BookCreate):
    db_book = models.Book(
        title=book.title,
        description=book.description,
        genre=book.genre,
        author_id=book.author_id
    )
    db.add(db_book)
    db.commit()
    db.refresh(db_book)
    return db_book

def get_books(db: Session):
    return db.query(models.Book).all()

def get_books_by_author(db: Session, author_id: int):
    return db.query(models.Book).filter(models.Book.author_id == author_id).all()

def get_books_by_genre(db: Session, genre: str):
    return db.query(models.Book).filter(models.Book.genre == genre).all()

def get_authors_by_genre(db: Session, genre: str):
    return db.query(models.Author).join(models.Author.books).filter(models.Book.genre == genre).distinct().all()

def get_books_by_author_and_genre(db: Session, author_id: int, genre: str):
    return db.query(models.Book).filter(and_(models.Book.author_id == author_id, models.Book.genre == genre)).all()