package com.example.springtest.exceptions;

import java.lang.RuntimeException;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}