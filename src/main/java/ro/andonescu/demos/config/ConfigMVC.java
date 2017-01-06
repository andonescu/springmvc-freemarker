package ro.andonescu.demos.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ro.andonescu.demos.springmvcfreemarker.controllers")
public class ConfigMVC extends WebMvcConfigurerAdapter {

    @Bean
    public LocaleResolver LogetLocalResolver() {
        return new FixedLocaleResolver(new Locale("ro"));
    }

    private Properties getFreeMarkerProperties() {
        Properties properties = new Properties();
        properties.setProperty("datetime_format", "dd.MM.yyyy");
        properties.setProperty("number_format", "#");
        properties.setProperty("whitespace_stripping", "true");
        properties.setProperty("auto_include", "lib/implicit.ftl");
        properties.setProperty("default_encoding", "UTF-8");
        return properties;
    }

    @Bean
    public FreeMarkerConfig getFreeMarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setFreemarkerSettings(getFreeMarkerProperties());
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/freemarker/");

        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }
}
