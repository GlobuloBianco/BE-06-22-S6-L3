package com.S5L5WP.BE0622WJH;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class Be0622WjhApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mvc.perform(get("/istruzione/it"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("OK")));
	}

}
