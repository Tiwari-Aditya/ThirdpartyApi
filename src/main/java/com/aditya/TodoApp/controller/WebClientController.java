package com.aditya.TodoApp.controller;

import com.aditya.TodoApp.customresponse.ApiResponse;
import com.aditya.TodoApp.entity.Todo;
import com.aditya.TodoApp.service.WebClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class WebClientController {

    private final WebClientService todoService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllTodos() {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Found It",todoService.getAllTodos());
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public Mono<Todo> getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @GetMapping("/completed/{completed}")
    public Flux<Todo> getTodosByCompleted(@PathVariable boolean completed) {
        return todoService.getTodosByCompleted(completed);
    }
}
