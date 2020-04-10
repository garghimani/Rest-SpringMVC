package com.rest.bo;

import com.rest.validation.AccountValidationException;
import com.rest.vo.AccountVOO;

public interface AccountBO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}