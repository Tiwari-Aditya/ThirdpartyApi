package com.aditya.TodoApp.service;

import com.aditya.TodoApp.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestTemplateService {

    private final RestTemplate restTemplate;
    @Value("${jsonplaceholder.api.url}")
    private String apiUrl;

    public List<Todo> getAll() {
        String todoUrl = apiUrl;
        return restTemplate.getForObject(todoUrl, List.class);
    }

    public List<Todo> getToddByUserId(Long userId) {
        String todoUrl = apiUrl + "?userId={userId}";
        return restTemplate.getForObject(todoUrl, List.class, userId);
    }

    public Todo getTodoById(Long todoId) {
        String todoUrl = apiUrl + "/{id}";
        return restTemplate.getForObject(todoUrl, Todo.class, todoId);
    }

    public List<Todo> getUserByUserIdAndId(Long userId, Long id) {
        String todoUrl = apiUrl + "?userid={userId}&id={id}";
        return restTemplate.getForObject(todoUrl, List.class, userId, id);
    }

    public List<Todo> getTodoByStatus(boolean completed) {
        String todoUrl = apiUrl + "?completed={completed}";
        return restTemplate.getForObject(todoUrl, List.class, completed);
    }

}
