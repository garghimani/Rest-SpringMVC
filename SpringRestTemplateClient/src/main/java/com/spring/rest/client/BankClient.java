package com.spring.rest.client;

import org.springframework.http.HttpStatus;

import com.spring.rest.model.BankInfoVOO;

public interface BankClient {

	HttpStatus addBank(BankInfoVOO bank);

	BankInfoVOO getBank(String firstName);

	void updateBank(BankInfoVOO bank);

	void deleteBank(String firstName);

}