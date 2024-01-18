package com.aditya.TodoApp.customresponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String status;
    private String message;
    private Object data;
}
