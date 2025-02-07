package com.opf.project.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException() {
        ErrorDetails errorDetails = new ErrorDetails("alphabet", true);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
