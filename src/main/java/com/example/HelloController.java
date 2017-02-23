package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @PatchMapping("/")
    public String patchRoute() {
        return "PUT to index";
    }

    @DeleteMapping("/")
    public String deleteRoute(){
        return "DELETE to index";
    }

    // Querrystring Data
    @GetMapping("/puppies")
    public String getIndividualParams(
        @RequestParam("name") String name,
        @RequestParam("age") Integer age) {
        return String.format("Puppy name is %s and age is %s", name, age);
    }

    @GetMapping("/vehicles")
    public String getMapParams(@RequestParam MultiValueMap<String, String> querystring) {
        return querystring.toString();
    }

    @GetMapping("/pastries")
    public String getObjectParams(Pastries pastries) {
        return String.format("This %s is %s calories and cost %s",
            pastries.getName(),
            pastries.getCalories(),
            pastries.getPrice());
    }
    
}