package ro.andonescu.demos.springmvcfreemarker.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ro.andonescu.demos.springmvcfreemarker.config.AbstractTest;

public class RegistrationControllerTest extends AbstractTest {

	@Before
	public void setUp() throws Exception {
		setupMockMvc();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowRegistration() throws Exception {
		this.mockMvc
				.perform(get("/registration/view"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(
						MockMvcResultMatchers.view().name("views/registration"));
	}

	@Test
	public void testShowAddForm() throws Exception {
		this.mockMvc
		.perform(get("/registration/add"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("text/html;charset=UTF-8"))
		.andExpect(
				MockMvcResultMatchers.view().name("forms/registration"));
	}

	@Test
	public void testValidateAddForm() throws Exception {
		// request.setMethod("POST");
		// request.setRequestURI("/registration/add");
		// request.setAttribute("registrationForm", new RegistrationForm());
		//
		// updateServletRequestAttributes();
		//
		// ModelAndView modelView = requestHandlerAdapter.handle(request,
		// response, registrationController);
		// assertEquals("forms/registration", modelView.getViewName());
	}

}
