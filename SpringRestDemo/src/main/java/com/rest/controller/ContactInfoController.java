package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bo.ContactInfoBO;
import com.rest.validation.AccountValidationException;
import com.rest.vo.ContactInfoVOO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
public class ContactInfoController {
	
	@Autowired
	ContactInfoBO contactBO;

	// ----------------------RETRIEVE SINGLE CONTACT DETAIL----------------------------

	@GET
	@RequestMapping(value = "/getContact/{firstName}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<ContactInfoVOO> getContactDetails(@PathVariable("firstName") String firstName)
			throws AccountValidationException, Exception {
		System.out.println("Inside getContact....");
		if (contactBO.viewContactInfo(firstName) == null) {
			return new ResponseEntity<ContactInfoVOO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ContactInfoVOO>(contactBO.viewContactInfo(firstName), HttpStatus.OK);

	}

	// -----------------------CREATE A CONTACT DETAIL-----------------------------------

	@POST
	@RequestMapping(value = "/createContact")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createContact(@RequestBody ContactInfoVOO contact)
			throws AccountValidationException, Exception {
		System.out.println("Inside createContact...");
		System.out.println("First Name : " + contact.getPersonID());
		contactBO.addContactInfo(contact);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// -------------------------UPDATE A CONTACT DETAIL----------------------------------------

	@PUT
	@RequestMapping(value = "/updateContact")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<Void> updateContact(@RequestBody ContactInfoVOO contact)
			throws AccountValidationException, Exception {
		System.out.println("Inside updateContact...");
		System.out.println("First Name : " + contact.getPersonID());
		contactBO.modifyContactInfo(contact);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	// -------------------------DELETE A CONTACT DETAIL----------------------------------------

	@DELETE
	@RequestMapping(value = "/deleteContact/{firstName}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<Void> deleteContact(@PathVariable("firstName") String firstName)
			throws AccountValidationException, Exception {
		System.out.println("Inside deleteContact...");
		System.out.println("First Name : " + firstName);
		contactBO.deleteContactInfo(firstName);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}
