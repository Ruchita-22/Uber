package com.example.Uber.exceptions;

public class RiderNotFoundException extends RuntimeException{
    public RiderNotFoundException() {
    }

    public RiderNotFoundException(String message) {
        super(message);
    }
}
