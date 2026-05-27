package com.nutrinest.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(400).body(
                Map.of("message", ex.getMessage())
        );
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<?> handlePhoneExists(PhoneAlreadyExistsException ex) {
        return ResponseEntity.status(400).body(
                Map.of("message", ex.getMessage())
        );
    }
}