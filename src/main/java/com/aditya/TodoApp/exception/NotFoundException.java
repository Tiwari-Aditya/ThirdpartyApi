package com.aditya.TodoApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NotFoundException extends RuntimeException{
    private final String status;
    private final String message;
}
