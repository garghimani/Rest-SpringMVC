package com.spring.rest.client;

import org.springframework.http.HttpStatus;

import com.spring.rest.model.ContactInfoVOO;

public interface ContactClient {

	HttpStatus addContact(ContactInfoVOO contact);

	ContactInfoVOO getContact(String firstName);

	void updateContact(ContactInfoVOO contact);

	void deleteContact(String firstName);

}