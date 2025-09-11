from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session
from app.database import SessionLocal
from app import crud, schemas

router = APIRouter()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

@router.post("/authors/", response_model=schemas.AuthorRead)
def create_author(author: schemas.AuthorCreate, db: Session = Depends(get_db)):
    return crud.create_author(db, author)

@router.get("/authors/", response_model=list[schemas.AuthorRead])
def list_authors(db: Session = Depends(get_db)):
    return crud.get_authors(db)

@router.post("/books/", response_model=schemas.BookRead)
def create_book(book: schemas.BookCreate, db: Session = Depends(get_db)):
    return crud.create_book(db, book)

@router.get("/books/", response_model=list[schemas.BookRead])
def list_books(db: Session = Depends(get_db)):
    return crud.get_books(db)

@router.get("/books/author/{author_id}", response_model=list[schemas.BookRead])
def get_books_by_author(author_id: int, db: Session = Depends(get_db)):
    return crud.get_books_by_author(db, author_id)

@router.get("/books/genre/{genre}", response_model=list[schemas.BookRead])
def get_books_by_genre(genre: str, db: Session = Depends(get_db)):
    return crud.get_books_by_genre(db, genre)

@router.get("/authors/genre/{genre}", response_model=list[schemas.AuthorRead])
def get_authors_by_genre(genre: str, db: Session = Depends(get_db)):
    return crud.get_authors_by_genre(db, genre)

@router.get("/books/author/{author_id}/genre/{genre}", response_model=list[schemas.BookRead])
def get_books_by_author_and_genre(author_id: int, genre: str, db: Session = Depends(get_db)):
    return crud.get_books_by_author_and_genre(db, author_id, genre)