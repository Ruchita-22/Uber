package com.example.Uber.exceptions;

public class RiderAlreadyExistException extends RuntimeException{
    public RiderAlreadyExistException() {
    }

    public RiderAlreadyExistException(String message) {
        super(message);
    }
}
