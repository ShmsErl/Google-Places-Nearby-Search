package com.codexist.nearbysearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;


    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(HttpClientErrorException.class)
        public ResponseEntity<Map<String, String>> handleClientError(HttpClientErrorException ex) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("status", ex.getStatusCode().toString());
            errorDetails.put("error", "Client Error");
            errorDetails.put("message", ex.getMessage());

            return ResponseEntity
                    .status(ex.getStatusCode())
                    .body(errorDetails);
        }

        @ExceptionHandler(HttpServerErrorException.class)
        public ResponseEntity<Map<String, String>> handleServerError(HttpServerErrorException ex) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("status", ex.getStatusCode().toString());
            errorDetails.put("error", "Server Error");
            errorDetails.put("message", ex.getMessage());

            return ResponseEntity
                    .status(ex.getStatusCode())
                    .body(errorDetails);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
            errorDetails.put("error", "Internal Server Error");
            errorDetails.put("message", ex.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorDetails);
        }
    }