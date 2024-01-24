package com.aditya.TodoApp.exception;

import com.aditya.TodoApp.customresponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse("Error", ex.getMessage(), null);
        return ResponseEntity.status(404).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenricException(Exception ex) {
        ApiResponse apiResponse = new ApiResponse("Error", ex.getMessage(), null);
        return ResponseEntity.status(500).body(apiResponse);
    }
}
