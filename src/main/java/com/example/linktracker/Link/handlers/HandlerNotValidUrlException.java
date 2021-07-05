package com.example.linktracker.Link.handlers;

import com.example.linktracker.exception.NotValidUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HandlerNotValidUrlException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotValidUrlException.class)
    public ResponseEntity<?> handleNotValidUrlException(NotValidUrlException exception) {
        return ResponseEntity.notFound().build();
    }

}
