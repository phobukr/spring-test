package main

import (
	"errors"
	"fmt"
)

type Book struct {
	id       int
	title    string
	authorID int
	genre    string
}

type BookService struct {
	books []*Book
}

func NewBookService() (*BookService, error) {
	bookService := &BookService{
		books: []*Book{
			&Book{1, "Book 1", 1, "Fiction"},
			&Book{2, "Book 2", 1, "Non-Fiction"},
			&Book{3, "Book 3", 2, "Fiction"},
			&Book{4, "Book 4", 2, "Non-Fiction"},
			&Book{5, "Book 5", 1, "Fiction"},
		},
	}
	return bookService, nil
}

func (s *BookService) GetBooksByAuthorAndGenre(authorID int, genre string) ([]*Book, error) {
	if authorID <= 0 {
		return nil, errors.New("authorID must be greater than 0")
	}
	if len(genre) == 0 {
		return nil, errors.New("genre cannot be empty")
	}

	var result []*Book
	for _, book := range s.books {
		if book.authorID == authorID && book.genre == genre {
			result = append(result, book)
		}
	}
	if len(result) == 0 {
		return nil, fmt.Errorf("no books found for authorID %d and genre %s", authorID, genre)
	}
	return result, nil
}

func main() {
	bookService, err := NewBookService()
	if err != nil {
		fmt.Println(err)
		return
	}
	authorID := 1
	genre := "Fiction"
	result, err := bookService.GetBooksByAuthorAndGenre(authorID, genre)
	if err != nil {
		fmt.Println(err)
		return
	}
	for _, book := range result {
		fmt.Printf("ID: %d, Title: %s, Author ID: %d, Genre: %s\n", book.id, book.title, book.authorID, book.genre)
	}
}