package edu.mum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan("edu.mum.component") // search the edu.mum.component package for @Component classes
public class JavaConfiguration {
	
	/*
	 * Configures ReloadableResourceBundleMessageSource 
	 * associates it with the properties file from which to get the message...
	 * The properties file is in classpath and is named HelloWorld.properties
	 * 
	 */

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:HelloWorld");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }

	
}
