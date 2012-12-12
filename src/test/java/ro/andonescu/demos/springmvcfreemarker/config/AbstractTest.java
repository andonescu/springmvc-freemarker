/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.config;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * @author iandonescu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		MainConfig.class, SessionConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("testing")
public abstract class AbstractTest {
	@Autowired
	protected ApplicationContext ac;

	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;

	protected void setUpRequest(ConfigurableApplicationContext context) {
		context.getBeanFactory().registerScope("session", new SessionScope());
		request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}

}
