from pydantic import BaseModel
from typing import List, Optional

class BookCreate(BaseModel):
    title: str
    description: Optional[str] = None
    genre: Optional[str] = None
    author_id: int

class BookRead(BookCreate):
    id: int
    class Config:
        orm_mode = True

class AuthorCreate(BaseModel):
    name: str

class AuthorRead(AuthorCreate):
    id: int
    books: Optional[List[BookRead]] = []
    class Config:
        orm_mode = True