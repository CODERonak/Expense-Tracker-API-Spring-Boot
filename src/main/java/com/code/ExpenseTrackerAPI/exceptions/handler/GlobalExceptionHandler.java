package com.code.ExpenseTrackerAPI.exceptions.handler;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.code.ExpenseTrackerAPI.exceptions.custom.*;
import com.code.ExpenseTrackerAPI.exceptions.payload.ErrorResponse;

// This controller handles the exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {
    // This method handles the UsernameAlreadyExistsException
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex) {
        // This creates a new error response
        // and returns it
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // This method handles the EmailAlreadyExistsException
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        // This creates a new error response
        // and returns it
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // This method handles the InvalidCredentialsException
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {
        // This creates a new error response
        // and returns it
        ErrorResponse error = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}