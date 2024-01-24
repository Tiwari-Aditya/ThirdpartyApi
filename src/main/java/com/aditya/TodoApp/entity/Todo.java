package com.aditya.TodoApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
