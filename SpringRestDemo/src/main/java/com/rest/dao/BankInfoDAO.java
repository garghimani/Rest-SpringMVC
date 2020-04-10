package com.rest.dao;

import com.rest.validation.AccountValidationException;
import com.rest.vo.BankInfoVOO;

public interface BankInfoDAO {

	void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception;

	BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception;

	void modifyBankInfo(BankInfoVOO modifybankVOO) throws AccountValidationException, Exception;

	void deleteBankInfo(String firstName) throws AccountValidationException, Exception;

}