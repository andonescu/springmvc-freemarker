/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.service;

import java.util.List;

import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;

/**
 * @author iandonescu
 * 
 */
public interface RegistrationService {

	void saveData(RegistrationForm registrationForm);

	List<RegistrationForm> getData();

}
