package ro.andonescu.demos.springmvcfreemarker.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ro.andonescu.demos.springmvcfreemarker.config.AbstractTest;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;

public class RegistrationControllerTest extends AbstractTest {

	@Before
	public void setUp() throws Exception {
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
	public void testValidateAddForm_withErrors() throws Exception {
		this.mockMvc
				.perform(
						post("/registration/add").requestAttr(
								"registrationForm", new RegistrationForm()))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(
						MockMvcResultMatchers.view().name("forms/registration"))
				.andExpect(model().hasErrors());
	}

	@Test
	public void testValidateAddForm_withoutErrors() throws Exception {
		this.mockMvc
				.perform(
						post("/registration/add").requestAttr(
								"registrationForm", getCompletedRegistration()))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(
						MockMvcResultMatchers.view().name(
								"forms/registration_success"))
				.andExpect(model().hasNoErrors());
	}

	private RegistrationForm getCompletedRegistration() {
		// TODO: replace this with a builder
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setAddress("address1");
		registrationForm.setAgreement(true);
		registrationForm.setBirthDate(new DateTime().minusYears(19).toDate());
		registrationForm.setCity("Iasi");
		registrationForm.setCounty("Iasi");
		registrationForm.setFirstName("John");
		registrationForm.setLastName("Daniel");
		registrationForm.setPassword("123456");
		registrationForm.setPasswordConf("123456");
		registrationForm.setEmail("ando@test.ro");

		return registrationForm;
	}
}
