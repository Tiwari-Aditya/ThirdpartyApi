package com.aditya.TodoApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class Todo {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
