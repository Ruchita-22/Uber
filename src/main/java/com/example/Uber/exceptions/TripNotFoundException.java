package com.example.Uber.exceptions;

public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException() {
    }

    public TripNotFoundException(String message) {
        super(message);
    }
}
