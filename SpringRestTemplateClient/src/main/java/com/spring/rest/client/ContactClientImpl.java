package com.spring.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.model.ContactInfoVOO;

@Service
public class ContactClientImpl implements ContactClient {

	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "http://localhost:8080/SpringRestDemo/contact";
	
	@Override
	public HttpStatus addContact(ContactInfoVOO contact) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI+"/addContact", contact, HttpStatus.class);
		return response.getBody();
	}

	@Override
	public ContactInfoVOO getContact(String firstName) {
		ResponseEntity<ContactInfoVOO> response = restTemplate.getForEntity(ROOT_URI + "/getContact/"+firstName, ContactInfoVOO.class);
		return response.getBody();
	}

	@Override
	public void updateContact(ContactInfoVOO contact) {
		restTemplate.put(ROOT_URI+"/updateContact", contact);
		
	}

	@Override
	public void deleteContact(String firstName) {
		restTemplate.delete(ROOT_URI+"/deleteContact" + firstName);
		
	}

}
