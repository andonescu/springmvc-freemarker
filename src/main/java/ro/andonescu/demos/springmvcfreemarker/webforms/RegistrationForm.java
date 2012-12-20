package ro.andonescu.demos.springmvcfreemarker.webforms;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;

import ro.andonescu.demos.springmvcfreemarker.util.AgeVerification;
import ro.andonescu.demos.springmvcfreemarker.util.DateUtil;

// @ScriptAssert(lang = "javascript", script =
// "_this.password.trim().length() == 0 || _this.password ==_this.passwordConf",
// message = "Passwords do Not Match!")
public class RegistrationForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@NotEmpty
	private String passwordConf;

	@NotEmpty
	private String lastName;
	@NotEmpty
	private String firstName;

	@NotNull
	@AgeVerification
	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date birthDate;

	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String county;

	@AssertTrue
	private Boolean agreement;

	@Override
	public void additionalVerification(BindingResult bindingResult) {
		if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(passwordConf)) {
			if (password.compareTo(passwordConf) != 0) {
				bindingResult.rejectValue("passwordConf", "passwordsDontMatch");
			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Boolean getAgreement() {
		return agreement;
	}

	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationForm [email=").append(email).append(", password=").append(password)
				.append(", passwordConf=").append(passwordConf).append(", lastName=").append(lastName)
				.append(", firstName=").append(firstName).append(", birthDate=").append(birthDate).append(", address=")
				.append(address).append(", city=").append(city).append(", county=").append(county)
				.append(", agreement=").append(agreement).append("]");
		return builder.toString();
	}

	

}
