package ro.andonescu.demos.springmvcfreemarker.config;

import java.util.HashMap;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class SessionConfig {

	@Bean
	public SimpleThreadScope getSimpleThreadScope() {
		return new SimpleThreadScope();
	}

	@Bean
	public CustomScopeConfigurer getCustomScopeConfigurer() {
		CustomScopeConfigurer scope = new CustomScopeConfigurer();
		scope.setScopes(new HashMap<String, Object>() {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			{
				put("sesion", getSimpleThreadScope());
			}
		});
		return scope;
	}
}
