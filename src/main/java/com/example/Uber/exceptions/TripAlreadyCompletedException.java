package com.example.Uber.exceptions;

public class TripAlreadyCompletedException extends RuntimeException{
    public TripAlreadyCompletedException() {
    }

    public TripAlreadyCompletedException(String message) {
        super(message);
    }
}
