package com.aditya.TodoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    @ResponseBody
    public String welcomePage(){
        return "Welcome to Todo api consuming application!!";
    }
}
