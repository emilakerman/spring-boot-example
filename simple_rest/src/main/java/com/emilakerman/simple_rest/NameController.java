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

    /**
     * The getRandomName function returns a random name from a list of names.
     * 
     * @return The `getRandomName` method returns a random name from the `names` list.
     */
    @GetMapping("/random")
    @ResponseBody
    public String getRandomName() {
        Random rand = new Random();
        int name = rand.nextInt(names.toArray().length);
        return names.get(name);
    }
    /**
     * The getAllNames function returns an ArrayList of strings containing all names.
     * 
     * @return An ArrayList of Strings containing names is being returned.
     */
    @GetMapping("/all")
    @ResponseBody
    public ArrayList<String> getAllNames() {
        return names;
    }
    /**
     * The postName function adds a name to a list called names.
     * 
     * @param name The parameter "name" in the `postName` method is a path variable that is extracted from the URL path. It is then added to a collection named `names`.
     */
    @PostMapping("/add/{name}")
    public void postName(@PathVariable String name) {
        names.add(name);
    }
}
