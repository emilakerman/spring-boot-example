package com.example.simple_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/api/test")
    public String getString() {
        return "Hello2";
    }
    
}
