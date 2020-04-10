package com.spring.rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;

import com.spring.rest.client.PersonClient;
import com.spring.rest.config.AccountConfig;
import com.spring.rest.model.PersonalInfoVOO;

public class AccountMainClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);

		PersonClient client = applicationContext.getBean(PersonClient.class);

		System.out.println("\nGetting person with firstName test1");

		PersonalInfoVOO person = client.getPerson("test1");

		System.out.println(person);

		/*
		 * System.out.println("Adding a Person"); PersonalInfoVOO p = new
		 * PersonalInfoVOO(); p.setFirstName("David"); p.setMiddleName("T");
		 * p.setLastName("Blain"); p.setGender("male"); HttpStatus status =
		 * client.addPerson(p); System.out.println("Add Person Response = " + status);
		 */

		applicationContext.close();
	}

}
