/**
 * 
 */
package ro.andonescu.demos.config;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "ro.andonescu.demos.springmvcfreemarker", excludeFilters = { @ComponentScan.Filter(Configuration.class) })
@PropertySource(name = "appProps", value = { "classpath:app.properties"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class MainConfig {
	
	@Inject
	private Environment environment;

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/messages");
		return messageSource;
	}

}
