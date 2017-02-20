package ro.andonescu.demos.springmvcfreemarker.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import ro.andonescu.demos.springmvcfreemarker.config.AbstractTest;
import ro.andonescu.demos.springmvcfreemarker.util.TestUtil;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationFormBuilder;

public class UsersControllerTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidateCreateUser_withoutErrors() throws Exception {
        ;
        MockMultipartFile uploadedFile = new MockMultipartFile("file", "filename.txt", "text/plain",
                "some xml".getBytes());

        MockMultipartFile userRegistrationData = new MockMultipartFile("data", "", "application/json;charset=UTF-8",
                new ObjectMapper().writeValueAsBytes(getRegistrationForm(true)));

        this.mockMvc.perform(TestUtil.fileUploadReq("/users", Arrays.asList(uploadedFile, userRegistrationData)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(model().hasNoErrors());
    }

    private RegistrationForm getRegistrationForm(Boolean agreement) {
        return RegistrationFormBuilder.registrationForm().withAddress("address1").withAgreement(agreement)
                .withBirthDate(new DateTime().minusYears(19).toDate()).withCity("Iasi").withCounty("Iasi")
                .withFirstName("John").withLastName("Daniel").withPassword("123456").withPasswordConf("123456")
                .withEmail("ando@test.ro").build();
    }
}
