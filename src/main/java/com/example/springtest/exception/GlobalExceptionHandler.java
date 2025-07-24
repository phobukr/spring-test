package com.example.springtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoBooksFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoBooksFound(NoBooksFoundException ex) {
        return ex.getMessage();
    }
}

package com.example.springtest.exception;

public class NoBooksFoundException extends RuntimeException {
    public NoBooksFoundException(String message) {
        super(message);
    }
}