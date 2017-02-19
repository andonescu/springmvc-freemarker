package ro.andonescu.demos.springmvcfreemarker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> validateAddForm(MultipartFile file) {


        return ResponseEntity.ok("");
    }
}
