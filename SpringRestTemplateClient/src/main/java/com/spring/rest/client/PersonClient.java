package com.spring.rest.client;

import org.springframework.http.HttpStatus;

import com.spring.rest.model.PersonalInfoVOO;

public interface PersonClient {
	
	HttpStatus addPerson(PersonalInfoVOO person);
	
	PersonalInfoVOO getPerson(String firstName);
	
	void updatePerson(PersonalInfoVOO person);

	void deletePerson(String firstName);

}
