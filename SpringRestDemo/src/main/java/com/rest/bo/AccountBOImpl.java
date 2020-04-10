package com.rest.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.AccountDAO;
import com.rest.validation.AccountValidationException;
import com.rest.vo.AccountVOO;

@Service
public class AccountBOImpl implements AccountBO {

	@Autowired
    AccountDAO accDAO;

	public AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception {

		AccountVOO accVO = accDAO.getLoginDetails(accountVO);
		return accVO;
	}

	public void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception {
		System.out.println("LoginBO : addLoginDetails() : Start");
		accDAO.addLoginDetails(accountVO);
		System.out.println("LoginBO : addLoginDetails() : End");

	}

	

}
