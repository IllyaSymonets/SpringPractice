package com.spingpractice.week1.exception;

public class ArgumentNotValidException extends RuntimeException {
    public ArgumentNotValidException(String message) {
        super(message);
    }
}
