package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bo.BankInfoBO;
import com.rest.validation.AccountValidationException;
import com.rest.vo.BankInfoVOO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
public class BankInfoController {

	@Autowired
	BankInfoBO bankBO;

	// ----------------------RETRIEVE SINGLE BANK DETAIL----------------------------

		@GET
		@RequestMapping(value = "/getBank/{firstName}")
		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public ResponseEntity<BankInfoVOO> getBankDetails(@PathVariable("firstName") String firstName)
				throws AccountValidationException, Exception {
			System.out.println("Inside getBank....");
			if (bankBO.viewBankInfo(firstName) == null) {
				return new ResponseEntity<BankInfoVOO>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<BankInfoVOO>(bankBO.viewBankInfo(firstName), HttpStatus.OK);

		}

		// -----------------------CREATE A BANK DETAIL-----------------------------------

		@POST
		@RequestMapping(value = "/createBank")
		@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public ResponseEntity<Void> createBank(@RequestBody BankInfoVOO bank)
				throws AccountValidationException, Exception {
			System.out.println("Inside createBank...");
			System.out.println("First Name : " + bank.getPersonId());
			bankBO.addBankInfo(bank);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

		// -------------------------UPDATE A BANK DETAIL----------------------------------------

		@PUT
		@RequestMapping(value = "/updateBank")
		@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public ResponseEntity<Void> updateBank(@RequestBody BankInfoVOO bank)
				throws AccountValidationException, Exception {
			System.out.println("Inside updateBank...");
			System.out.println("First Name : " + bank.getPersonId());
			bankBO.modifyBankInfo(bank);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

		// -------------------------DELETE A BANK DETAIL----------------------------------------

		@DELETE
		@RequestMapping(value = "/deleteBank/{firstName}")
		@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public ResponseEntity<Void> deleteBank(@PathVariable("firstName") String firstName)
				throws AccountValidationException, Exception {
			System.out.println("Inside deleteBank...");
			System.out.println("First Name : " + firstName);
			bankBO.deleteBankInfo(firstName);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

}
