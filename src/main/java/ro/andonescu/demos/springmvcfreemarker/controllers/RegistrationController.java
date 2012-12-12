package ro.andonescu.demos.springmvcfreemarker.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.andonescu.demos.springmvcfreemarker.service.DataService;
import ro.andonescu.demos.springmvcfreemarker.service.RegistrationService;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;

@Controller
@RequestMapping("registration")
public class RegistrationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

	
	private DataService dataService;
	private RegistrationService registrationService;
	
	@Inject
	public RegistrationController(DataService dataService, RegistrationService registrationService) {
		this.dataService = dataService;
		this.registrationService = registrationService;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String showRegistration(Model model) {
		model.addAttribute("persons", registrationService.getData());
		return "views/registration";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddForm(Model model) {
		model.addAttribute(new RegistrationForm());		
		return "forms/registration";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String validateAddForm(@Valid RegistrationForm registrationForm, BindingResult bindingResult, Model model) {
		registrationForm.additionalVerification(bindingResult);
		LOGGER.debug(registrationForm.toString());
		
		if (bindingResult.hasErrors()) {
			model.addAttribute(registrationForm);
			return "forms/registration";
		}
		
		registrationService.saveData(registrationForm);
			
		
		return "forms/registration_success";
	}
	
	@ModelAttribute("dataService")
	private DataService getDataService(){
		return dataService;
	}
}
