package be.vdab.web;
import static
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import be.vdab.repositories.CreateRepositoryBeans;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CreateRepositoryBeans.class,
		CreateControllerBeans.class })
@WebAppConfiguration
@Transactional
public class PersonControllerTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void before() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void get() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/")  
				.accept(MediaType.TEXT_HTML))  
				.andExpect(status().isOk()); 
	}
	@Test
	public void post() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.content("name=john"));
	}

	
}
