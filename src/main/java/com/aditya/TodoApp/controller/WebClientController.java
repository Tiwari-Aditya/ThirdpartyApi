package com.aditya.TodoApp.controller;

import com.aditya.TodoApp.customresponse.ApiResponse;
import com.aditya.TodoApp.service.WebClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-client/api")
@AllArgsConstructor
public class WebClientController {

    private final WebClientService todoService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllTodos() {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Found It By Using Web Client", todoService.getAllTodos());
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTodoById(@PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Found It By Using Web Client", todoService.getTodoById(id));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ApiResponse> getTodoByUserId(@PathVariable Long uid) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Found It By Using Web Client", todoService.getTodosByUserId(uid));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/user/{uid}/id/{id}")
    public ResponseEntity<ApiResponse> getTodoByUserIdAndId(@PathVariable Long uid, @PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Found It By Using Web Client", todoService.getTodoByUserIdAndId(uid, id));
        return ResponseEntity.ok(apiResponse);
    }
}
