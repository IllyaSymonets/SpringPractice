package com.spingpractice.week1.advice;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spingpractice.week1.exception.ArgumentNotValidException;
import com.spingpractice.week1.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleRuntimeException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ex.getBindingResult()
                .getAllErrors().stream()
                .collect(Collectors.toMap(
                    error -> ((FieldError) error).getField(),
                    error -> Objects.nonNull(error.getDefaultMessage()) ? error.getDefaultMessage() : ""
                )));
    }

    @ExceptionHandler(value = ArgumentNotValidException.class)
    public ResponseEntity<String> handleArgumentNotValidException(ArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
