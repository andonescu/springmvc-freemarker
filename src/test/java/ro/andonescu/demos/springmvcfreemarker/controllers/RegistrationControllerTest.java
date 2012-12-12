package ro.andonescu.demos.springmvcfreemarker.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import ro.andonescu.demos.springmvcfreemarker.config.AbstractTest;

public class RegistrationControllerTest extends AbstractTest {

	
	private AnnotationMethodHandlerAdapter handlerAdapter;
	
	@Autowired
	private RegistrationController registrationController;

	@Before
	public void setUp() throws Exception {
		setUpRequest((ConfigurableApplicationContext) ac);
		handlerAdapter = new AnnotationMethodHandlerAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowRegistration() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/registration/view");
		ModelAndView modelView = handlerAdapter.handle(request, response, registrationController);
		assertEquals("views/registration", modelView.getViewName());		
	}

	@Test
	public void testShowAddForm() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/registration/add");
		ModelAndView modelView = handlerAdapter.handle(request, response, registrationController);
		assertEquals("forms/registration", modelView.getViewName());		
	}

	@Test
	public void testValidateAddForm() {
		fail("Not yet implemented");
	}

}
