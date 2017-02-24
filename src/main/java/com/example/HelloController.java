package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

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

    //Path Variables
    @GetMapping("/puppies/{puppyId}/name")
    public String getIndividualPath(@PathVariable int puppyId) {
        return String.format("This puppy has ID of %d", puppyId);
    }

    @GetMapping("/blog/posts/{postId}/comments/{commentId}")
    public String getAllPath(@PathVariable Map<String, String> pathVariables) {
        return pathVariables.toString(); // {postId={postId}, commentId={commentId}}
    }

    @GetMapping("/games/type/{type}/length/{length}")
    public String getCustomObjectPath(Games games) {
        return String.format("This is a %s game and it takes %d hr to play", games.getType(), games.getLength());
    }

    
}