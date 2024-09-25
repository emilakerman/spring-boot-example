package com.emilakerman.simple_rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/name")
public class NameController {
    ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));

    /**
     * The getRandomName function returns a random name from a list of names.
     * 
     * @return The `getRandomName` method returns a random name from the `names`
     *         list.
     */
    @GetMapping("/random")
    @ResponseBody
    public String getRandomName() {
        Random rand = new Random();
        int name = rand.nextInt(names.toArray().length);
        return names.get(name);
    }

    /**
     * The getAllNames function returns an ArrayList of strings containing all
     * names.
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
     * @param name The parameter "name" in the `postName` method is a path variable
     *             that is extracted from the URL path. It is then added to a
     *             collection named `names`.
     */
    @PostMapping("/add/{name}")
    public void postName(@PathVariable String name) {
        names.add(name);
    }

    /**
     * This delete function deletes a specified name from a list if it exists and
     * returns an appropriate response.
     * 
     * @param name The `name` parameter in the `@DeleteMapping` method represents
     *             the name of the resource that you want to delete. This method
     *             takes the name as a path variable in the URL and then checks if
     *             the `names` list contains the specified name. If the name is
     *             found in the list,
     * @return A `ResponseEntity<Void>` is being returned.
     */
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        if (!names.contains(name)) {
            return ResponseEntity.notFound().build();
        }
        names.remove(name);
        return ResponseEntity.ok().build();
    }

    /**
     * This patch function updates a name in a list by replacing the old name with a new
     * name.
     * 
     * @param oldName The `oldName` parameter in the `update` method represents the
     *                name that you want to update in the list of names.
     * @param newName The `newName` parameter in the `update` method represents the
     *                new name that you want to update the existing name with.
     * @return The method is returning a `ResponseEntity<Void>`. If the oldName is
     *         not found in the list of names, it returns a 404 Not Found response.
     *         If the oldName is found, it updates the name in the
     *         list and returns a 200 OK response.
     */
    @PatchMapping("/update/{oldName}/{newName}")
    public ResponseEntity<Void> update(@PathVariable String oldName, @PathVariable String newName) {
        if (!names.contains(oldName)) {
            return ResponseEntity.notFound().build();
        }
        names.add(names.indexOf(oldName), newName);
        names.remove(oldName);
        return ResponseEntity.ok().build();
    }
}
