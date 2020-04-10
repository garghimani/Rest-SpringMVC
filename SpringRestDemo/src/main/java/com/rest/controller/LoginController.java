package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bo.AccountBO;
import com.rest.validation.AccountValidationException;
import com.rest.vo.AccountVOO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;

@RestController
public class LoginController {

	@Autowired
	AccountBO accBO;

	// -----------------------CREATE A LOGIN DETAIL-----------------------------------

	@POST
	@RequestMapping(value = "/createLogin")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createLogin(@RequestBody AccountVOO account)
			throws AccountValidationException, Exception {
		System.out.println("Inside createPerson...");
		System.out.println("UserName : " + account.getUserName());
		accBO.addLoginDetails(account);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
