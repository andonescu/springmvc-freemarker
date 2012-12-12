/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.webforms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.BindingResult;

/**
 * @author iandonescu
 *
 */
public class ContactForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	@Size(min = 5, max = 50)
	private String firstName;
	@NotEmpty
	@Size(min = 5, max = 50)
	private String lastName;
	@NotEmpty
	@Size(min = 7, max = 50)
	private String password;
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String state;
	
	/* (non-Javadoc)
	 * @see AbstractForm#additionalVerification(org.springframework.validation.BindingResult)
	 */
	@Override
	public void additionalVerification(BindingResult bindingResult) {
		// TODO Auto-generated method stub

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
