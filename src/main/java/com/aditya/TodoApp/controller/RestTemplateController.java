package com.aditya.TodoApp.controller;

import com.aditya.TodoApp.customresponse.ApiResponse;
import com.aditya.TodoApp.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-template/api")
@RequiredArgsConstructor
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllData() {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Data Found", restTemplateService.getAll());
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getDataByid(@PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Data Found", restTemplateService.getTodoById(id));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getDataByUserId(@PathVariable Long userId) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Data Found", restTemplateService.getToddByUserId(userId));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<ApiResponse> getDataByUserId(@PathVariable Boolean completed) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Data Found", restTemplateService.getTodoByStatus(completed));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/user/{userId}/id/{id}")
    public ResponseEntity<ApiResponse> getTodoByUserIdAndId(@PathVariable Long userId, @PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse("Sucess", "Data Found", restTemplateService.getUserByUserIdAndId(userId, id));
        return ResponseEntity.ok(apiResponse);
    }
}
