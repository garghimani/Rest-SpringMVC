package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bo.PersonalInfoBO;
import com.rest.validation.AccountValidationException;
import com.rest.vo.PersonalInfoVOO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(value = "/person")
public class PersonalInfoController {

	@Autowired
	PersonalInfoBO personBO;

	// ----------------------RETRIEVE SINGLE PERSON DETAIL----------------------------

	@GET
	@RequestMapping(value = "/getPerson/{firstName}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<PersonalInfoVOO> getPersonDetails(@PathVariable("firstName") String firstName)
			throws AccountValidationException, Exception {
		System.out.println("Inside getPerson....");
		if (personBO.viewPersonalInfo(firstName) == null) {
			return new ResponseEntity<PersonalInfoVOO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PersonalInfoVOO>(personBO.viewPersonalInfo(firstName), HttpStatus.OK);

	}

	// -----------------------CREATE A PERSON DETAIL-----------------------------------

	@POST
	@RequestMapping(value = "/createPerson")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createPerson(@RequestBody PersonalInfoVOO person)
			throws AccountValidationException, Exception {
		System.out.println("Inside createPerson...");
		System.out.println("First Name : " + person.getFirstName() + " " + person.getMiddleName());
		/*
		 * if (personBO.viewPersonalInfo(person.getFirstName()) != null) { return new
		 * ResponseEntity<Void>(HttpStatus.CONFLICT); }
		 */
		personBO.addPersonalInfo(person);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	//-------------------------UPDATE A PERSONAL DETAIL----------------------------------------
	
	@PUT
	@RequestMapping(value = "/updatePerson")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<PersonalInfoVOO> updatePerson(@RequestBody PersonalInfoVOO person)
			throws AccountValidationException, Exception {
		System.out.println("Inside createPerson...");
		System.out.println("First Name : " + person.getFirstName() + " " + person.getMiddleName());
		personBO.modifyPersonalInfo(person);
		return new ResponseEntity<PersonalInfoVOO>(HttpStatus.ACCEPTED);
	}
	
	//-------------------------DELETE A PERSONAL DETAIL----------------------------------------
	
	@DELETE
	@RequestMapping(value = "/deletePerson/{firstName}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<Void> deletePerson(@PathVariable("firstName") String firstName)
			throws AccountValidationException, Exception {
		System.out.println("Inside createPerson...");
		System.out.println("First Name : " + firstName);
		personBO.deletePersonalInfo(firstName);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
