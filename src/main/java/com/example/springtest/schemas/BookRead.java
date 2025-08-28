from pydantic import BaseModel
from datetime import date

class BookRead(BaseModel):
    id: int
    title: str
    author: str
    published_date: date