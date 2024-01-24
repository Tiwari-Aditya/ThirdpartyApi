package com.aditya.TodoApp.service;

import com.aditya.TodoApp.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;

    @Value("${jsonplaceholder.api.url}")
    private String apiUrl;

    public List<Todo> getAllTodos() {
        return webClient.get().uri(apiUrl).retrieve().bodyToFlux(Todo.class).collectList().block();
    }

    public Todo getTodoById(Long todoId) {
        return webClient.get().uri(apiUrl + "/{id}", todoId).retrieve().bodyToMono(Todo.class).block();
    }

    public List<Todo> getTodosByUserId(Long userId) {
        return webClient.get().uri(apiUrl + "?userId={userId}", userId).retrieve().bodyToFlux(Todo.class).collectList().block();
    }

    public List getTodoByUserIdAndId(Long userId, Long id) {
        return webClient.get().uri(apiUrl + "/?userId={userId}&id={id}", userId, id).retrieve().bodyToMono(List.class).block();
    }
}


