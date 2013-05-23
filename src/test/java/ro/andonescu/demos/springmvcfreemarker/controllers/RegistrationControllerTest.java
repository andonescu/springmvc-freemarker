package ro.andonescu.demos.springmvcfreemarker.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import ro.andonescu.demos.springmvcfreemarker.config.AbstractTest;
import ro.andonescu.demos.springmvcfreemarker.util.TestUtil;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationFormBuilder;

public class RegistrationControllerTest extends AbstractTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowRegistration() throws Exception {
		this.mockMvc.perform(get("/registration/view")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("views/registration"));
	}

	@Test
	public void testShowAddForm() throws Exception {
		this.mockMvc.perform(get("/registration/add")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("forms/registration"));
	}

	@Test
	public void testValidateAddForm_withErrors() throws Exception {
		MvcResult mvcResult = this.mockMvc
				.perform(TestUtil.postWithData("/registration/add", getRegistrationForm(false)))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("forms/registration")).andExpect(model().hasErrors()).andReturn();

		BeanPropertyBindingResult errors = (BeanPropertyBindingResult) mvcResult.getModelAndView().getModel()
				.get("org.springframework.validation.BindingResult.registrationForm");

		/**
		 * we receive only a single error and we validate the field name
		 */

		Assert.assertTrue(errors.getAllErrors().size() == 1);

		for (ObjectError error : errors.getAllErrors()) {
			FieldError fieldError = (FieldError) error;
			Assert.assertEquals("agreement", fieldError.getField());
		}

	}

	@Test
	public void testValidateAddForm_withoutErrors() throws Exception {
		this.mockMvc.perform(TestUtil.postWithData("/registration/add", getRegistrationForm(true)))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("forms/registration_success")).andExpect(model().hasNoErrors());
	}

	private RegistrationForm getRegistrationForm(Boolean agreement) {
		return RegistrationFormBuilder.registrationForm().withAddress("address1").withAgreement(agreement)
				.withBirthDate(new DateTime().minusYears(19).toDate()).withCity("Iasi").withCounty("Iasi")
				.withFirstName("John").withLastName("Daniel").withPassword("123456").withPasswordConf("123456")
				.withEmail("ando@test.ro").build();
	}

}
