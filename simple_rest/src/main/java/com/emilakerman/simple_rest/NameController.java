package com.emilakerman.simple_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/name")
public class NameController {
    ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));

    @GetMapping("/random")
    @ResponseBody
    public String getRandomName() {
        Random rand = new Random();
        int name = rand.nextInt(names.toArray().length);
        return names.get(name);
    }
    @GetMapping("/all")
    @ResponseBody
    public ArrayList<String> getAllNames() {
        return names;
    }
    @PostMapping("/add/{name}")
    public void postName(@PathVariable String name) {
        names.add(name);
    }
}
