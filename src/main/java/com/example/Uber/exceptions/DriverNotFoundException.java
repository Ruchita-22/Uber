package com.example.Uber.exceptions;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException() {
    }

    public DriverNotFoundException(String message) {
        super(message);
    }
}
