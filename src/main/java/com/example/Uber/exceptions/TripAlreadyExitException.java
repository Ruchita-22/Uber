package com.example.Uber.exceptions;

public class TripAlreadyExitException extends RuntimeException {
    public TripAlreadyExitException() {
    }

    public TripAlreadyExitException(String message) {
        super(message);
    }
}
