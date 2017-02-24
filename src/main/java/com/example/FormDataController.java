package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rb")
public class FormDataController {

    // An endpoint that references form data as a String
    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam String first_name, @RequestParam String last_name) {
        return String.format("Full Name: %s %s", first_name, last_name);
    }

    @PostMapping("/string-example")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

    // An endpoint that references form data as a HashMap
    @PostMapping(value = "/map-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getMapParams(@RequestParam Map<String, String> formData) {
        return formData.toString();
    }

    // An endpoint that references form data as a custom object
    @PostMapping(value = "/object-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getObjectParams(Person person) {
        return String.format("Person name: %s %s", person.getFirstName(), person.getLastName());
    }    

}