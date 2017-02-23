package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHelloEndpoint() throws Exception {
		this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello from Spring!"));
	}
	
	@Test
	public void testPatchEndpoint() throws Exception {
		this.mvc.perform(patch("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("PUT to index"));

	}

	@Test
	public void testDeleteEndpoint() throws Exception {
		this.mvc.perform(delete("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("DELETE to index"));
	}

	// Querrystring Data tests
	@Test
	public void testPuppiesEndpoint() throws Exception {
		this.mvc.perform(get("/puppies?name=Spot&age=1").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Puppy name is Spot and age is 1"));
	}

	@Test
	public void testVehiclesEndpoint() throws Exception {
		this.mvc.perform(get("/vehicles?make=Honda&model=Accord&year=1997").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("{make=[Honda], model=[Accord], year=[1997]}"));
	}

	@Test
	public void testPastriesEndpoint() throws Exception {
		this.mvc.perform(get("/pastries?name=doughnut&calories=300&price=14.95").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("This doughnut is 300 calories and cost 14.95"));
	}

}
