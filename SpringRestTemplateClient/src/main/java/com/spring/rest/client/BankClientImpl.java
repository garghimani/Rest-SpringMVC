package com.spring.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.model.BankInfoVOO;

@Service
public class BankClientImpl implements BankClient {

	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "http://localhost:8080/SpringRestDemo/bank";
	
	@Override
	public HttpStatus addBank(BankInfoVOO bank) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI+"/addBank", bank, HttpStatus.class);
		return response.getBody();
	}

	@Override
	public BankInfoVOO getBank(String firstName) {
		ResponseEntity<BankInfoVOO> response = restTemplate.getForEntity(ROOT_URI + "/getBank/"+firstName, BankInfoVOO.class);
		return response.getBody();
	}

	@Override
	public void updateBank(BankInfoVOO bank) {
		restTemplate.put(ROOT_URI+"/updatePerson", bank);
		
	}

	@Override
	public void deleteBank(String firstName) {
		restTemplate.delete(ROOT_URI+"/deletePerson" + firstName);
		
	}

}
