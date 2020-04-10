package com.spring.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.model.PersonalInfoVOO;

@Service
public class PersonClientImpl implements PersonClient {

	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "http://localhost:8080/SpringRestDemo/person";
	
	@Override
	public HttpStatus addPerson(PersonalInfoVOO person) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI+"/addPerson", person, HttpStatus.class);
		return response.getBody();
	}

	@Override
	public PersonalInfoVOO getPerson(String firstName) {
		ResponseEntity<PersonalInfoVOO> response = restTemplate.getForEntity(ROOT_URI + "/getPerson/"+firstName, PersonalInfoVOO.class);
		return response.getBody();
	}

	@Override
	public void updatePerson(PersonalInfoVOO person) {
		restTemplate.put(ROOT_URI+"/updatePerson", person);
		
	}

	@Override
	public void deletePerson(String firstName) {
		restTemplate.delete(ROOT_URI+"/deletePerson" + firstName);
		
	}

}
