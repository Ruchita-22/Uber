package com.example.Uber.exceptions;

public class DriverAlreadyExistException extends RuntimeException {
    public DriverAlreadyExistException() {
    }

    public DriverAlreadyExistException(String message) {
        super(message);
    }
}
