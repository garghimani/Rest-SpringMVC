package com.spring.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.model.PersonalInfoVOO;

@Configuration
@WebServlet(loadOnStartup=1)
@ComponentScan("com.spring.rest")
@ApplicationPath("/")
public class AccountConfig extends Application {
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
	
	 @Override
	 public Set<Class<?>> getClasses() {
	     Set<Class<?>> s = new HashSet<Class<?>>();
	     s.add(PersonalInfoVOO.class);
	     return s;
	 }

}
