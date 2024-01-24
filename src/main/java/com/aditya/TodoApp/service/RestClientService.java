package com.aditya.TodoApp.service;

import com.aditya.TodoApp.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestClientService {
    private final RestClient restClient;

    @Value("${jsonplaceholder.api.url}")
    private String apiUrl;

    public List<Todo> getAllTodos() {
        return restClient.get().uri(apiUrl).retrieve().body(List.class);
    }

    public Todo getTodoById(Long todoId) {
        return restClient.get().uri(apiUrl + "/{id}", todoId).retrieve().body(Todo.class);
    }

    public List<Todo> getTodosByUserId(Long userId) {
        return restClient.get().uri(apiUrl + "?userId={userId}", userId).retrieve().body(List.class);
    }

    public List getTodoByUserIdAndId(Long userId, Long id) {
        return restClient.get().uri(apiUrl + "/?userId={userId}&id={id}", userId, id).retrieve().body(List.class);
    }
}
