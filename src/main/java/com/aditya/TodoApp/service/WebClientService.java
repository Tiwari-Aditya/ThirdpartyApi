package com.aditya.TodoApp.service;

import com.aditya.TodoApp.entity.Todo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class WebClientService {


    private final WebClient webClient;


    public Flux<Todo> getAllTodos() {
        return webClient.get().uri("/todos").retrieve().bodyToFlux(Todo.class);
    }

    public Mono<Todo> getTodoById(int id) {
        return webClient.get().uri("/todos/{id}", id).retrieve().bodyToMono(Todo.class);
    }

    public Flux<Todo> getTodosByCompleted(boolean completed) {
        return webClient.get().uri("/todos?completed={completed}", completed).retrieve().bodyToFlux(Todo.class);
    }
}


