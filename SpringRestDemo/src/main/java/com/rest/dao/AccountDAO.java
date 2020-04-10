package com.rest.dao;

import com.rest.validation.AccountValidationException;
import com.rest.vo.AccountVOO;

public interface AccountDAO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}