package com.example.linktracker.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Senha informada está incorreta");
    }
}
