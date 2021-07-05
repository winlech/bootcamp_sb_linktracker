package com.example.linktracker.exception;

public class NotValidUrlException extends Throwable {

    public NotValidUrlException() {
        super("Link nao é valido");
    }
}
