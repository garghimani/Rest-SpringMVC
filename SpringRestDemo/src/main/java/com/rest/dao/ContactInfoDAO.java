package com.rest.dao;

import com.rest.validation.AccountValidationException;
import com.rest.vo.ContactInfoVOO;

public interface ContactInfoDAO {

	void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception;

	ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception;

	void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception;

	void deleteContactInfo(String firstName) throws AccountValidationException, Exception;

}