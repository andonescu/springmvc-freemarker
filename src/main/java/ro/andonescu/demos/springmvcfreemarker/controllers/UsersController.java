package ro.andonescu.demos.springmvcfreemarker.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;

@RestController
@RequestMapping("users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<String> validateAddForm(
            @RequestPart(value = "data") @Valid RegistrationForm registrationForm,
            BindingResult bindingResult,
            @RequestParam(value = "file") MultipartFile file) {

        LOGGER.info(registrationForm.toString());

        return ResponseEntity.ok("{}");
    }
}
