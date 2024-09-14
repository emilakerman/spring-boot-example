package com.example.simple_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class Controller {
    String[] names = { "Emil", "Dennis", "Birger", "Danne", "James", "Wally", "Jerry", "Thomas", "Muhammed"};

    @GetMapping("/api/test")
    public String getString() {
        return "Hello2";
    }

    @GetMapping("/api/randomName")
    public String getRandomName() {
        Random rand = new Random();
        int name = rand.nextInt(names.length);
        return names[name];
    }
}
