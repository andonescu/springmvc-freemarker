package ro.andonescu.demos.springmvcfreemarker.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.andonescu.demos.springmvcfreemarker.webforms.ContactForm;

@Controller
@RequestMapping("contact")
public class ContactController {

	@RequestMapping(method = RequestMethod.GET)
	public String showView(Model model) {
		model.addAttribute(new ContactForm());
		return "contact/view";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveView(@Valid ContactForm contactForm,
			BindingResult bindingResult, Model model) {
		contactForm.additionalVerification(bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute(contactForm);
			return "contact/view";
		}
		//TODO: here will call the service to save sent data
		return "contact/success";
	}

}
