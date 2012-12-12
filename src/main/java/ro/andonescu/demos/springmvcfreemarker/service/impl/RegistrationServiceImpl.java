package ro.andonescu.demos.springmvcfreemarker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.andonescu.demos.springmvcfreemarker.service.RegistrationService;
import ro.andonescu.demos.springmvcfreemarker.webforms.RegistrationForm;
import com.google.common.collect.Lists;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private List<RegistrationForm> data = Lists.newArrayList();

	public void saveData(RegistrationForm registrationForm) {
		data.add(registrationForm);
		//TODO: do something smarter here

	}

	public List<RegistrationForm> getData() {
		return data;
	}

}
