package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndividualParamsString() throws Exception {
        String first_name = "";
        String last_name = "";

        MockHttpServletRequestBuilder request = post("/rb/individual-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("first_name", first_name)
                .param("last_name", last_name);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Full Name: %s %s", first_name, last_name)));
    }

    @Test
    public void testRawBodyString() throws Exception {
        String first_name = "";
        String last_name = "";

        MockHttpServletRequestBuilder request = post("/rb/string-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("first_name", first_name)
                .param("last_name", last_name);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("first_name=%s&last_name=%s", first_name, last_name)));
    }

    @Test
    public void testHashMapString() throws Exception {
        String first_name = "";
        String last_name = "";

        MockHttpServletRequestBuilder request = post("/rb/map-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("first_name", first_name)
                .param("last_name", last_name);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{first_name=%s, last_name=%s}", first_name, last_name)));
    }

    @Test
    public void testCustomObject() throws Exception {
        String first_name = "Tom";
        String last_name = "Hanks";

        MockHttpServletRequestBuilder request = post("/rb/object-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", first_name)
                .param("lastName", last_name);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Person name: %s %s", first_name, last_name)));
    }
}