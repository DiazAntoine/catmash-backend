package latelier.catmash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle Exception for all endpoints
     * Precision : different behavior expected depending on the exception type
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        HttpStatus httpResult = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof IllegalArgumentException) {
            httpResult = HttpStatus.BAD_REQUEST;
        }
        else if (ex instanceof EntityNotFoundException) {
            httpResult = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpResult).body(ex.getMessage());
    }

}