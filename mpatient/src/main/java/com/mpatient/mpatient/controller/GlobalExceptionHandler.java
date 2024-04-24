package com.mpatient.mpatient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions thrown by controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	  /**
     * Handle exceptions of type Exception.
     *
     * @param ex The exception to handle.
     * @return ResponseEntity with HTTP status 500 and an error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        // Log the exception
        ex.printStackTrace();

        // Return ResponseEntity with HTTP status 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An internal server error occurred. Please try again later.");
    }
}

