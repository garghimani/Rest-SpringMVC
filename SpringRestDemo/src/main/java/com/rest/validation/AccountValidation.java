package com.rest.validation;

import com.rest.interfaces.ErrorMsgCodes;

public class AccountValidation {

	public AccountValidation() {
		super();
	}

	/*
	 * 
	 * Login Validations
	 * 
	 */
	public String validateUserName(String userName) {
		System.out.println("Inside Account Validation UserName: " + userName);
		if (userName.equals("")) {
			return ErrorMsgCodes.USER_ID_NULL;
		} else if (userName.trim().length() < 2) {
			return ErrorMsgCodes.USER_ID_INVALID;
		} else if (!(userName.matches("[a-zA-Z0-9@_ -]+"))) {
			return ErrorMsgCodes.USER_ID_INVALID;
		}
		return "";
	}

	public String validatePassword(String passwd) {
		System.out.println("Inside Account Validation Password: " + passwd);
		if (passwd.equals("")) {
			return ErrorMsgCodes.PASSWORD_NULL;
		} else if (passwd.trim().length() < 2) {
			return ErrorMsgCodes.USER_ID_INVALID;
		} else if (!(passwd.matches("[a-zA-Z0-9@_ -]+"))) {
			return ErrorMsgCodes.USER_ID_INVALID;
		}
		return "";
	}
	
	
	public String validateFirstName(String firstName) {
		System.out.println("Inside Account Validation FirstName: " + firstName);
		if (firstName == null || firstName.trim().length() == 0) {
			return ErrorMsgCodes.FIRST_NAME_IS_BLANK;
		} else if (firstName.trim().length() < 2) {
			return ErrorMsgCodes.FIRST_NAME_INVALID;
		} else if (!(firstName.matches("^[A-Za-z][a-zA-Z0-9_ -]+"))) {
			return ErrorMsgCodes.FIRST_NAME_INVALID;
		}
		return "";
	}

	/*
	 * 
	 * Personal Details Validation
	 * 
	 */

	public String validatePersonalDetails(String firstName, String middleName, String lastName, String gender) {
		System.out.println("Inside Account Validation Personal details : ");
		if (firstName == null || firstName.trim().length() == 0) {
			return ErrorMsgCodes.FIRST_NAME_IS_BLANK;
		} else if (firstName.trim().length() < 2) {
			return ErrorMsgCodes.FIRST_NAME_INVALID;
		} else if (!(firstName.matches("^[A-Za-z][a-zA-Z0-9_ -]+"))) {
			return ErrorMsgCodes.FIRST_NAME_INVALID;
		}

		if (middleName == null || middleName.trim().length() == 0) {
			return ErrorMsgCodes.MIDDLE_NAME_IS_BLANK;
		} else if (!(middleName.matches("[a-zA-Z0-9_ -]+"))) {
			return ErrorMsgCodes.MIDDLE_NAME_INVALID;
		}

		if (lastName == null || lastName.trim().length() == 0) {
			return ErrorMsgCodes.LAST_NAME_IS_BLANK;
		} else if (lastName.trim().length() < 2) {
			return ErrorMsgCodes.LAST_NAME_INVALID;
		} else if (!(lastName.matches("^[A-Za-z][a-zA-Z0-9_ -]+"))) {
			return ErrorMsgCodes.LAST_NAME_INVALID;
		}
		return "";
	}

	/*
	 * 
	 * Contact Details Validation
	 * 
	 * 
	 */

	public String validateContactDetails(String address, String city, String state, String country, String phone,
			String personId) {
		if (address == null || address.trim().length() == 0) {
			return ErrorMsgCodes.ADDRESS_IS_BLANK;
		}

		if (city == null || city.trim().length() == 0) {
			return ErrorMsgCodes.CITY_IS_BLANK;
		}

		if (state == null || state.trim().length() == 0) {
			return ErrorMsgCodes.STATE_IS_BLANK;
		}

		if (country == null || country.trim().length() == 0) {
			return ErrorMsgCodes.COUNTRY_IS_BLANK;
		}

		if (phone == null || phone.trim().length() == 0) {
			return ErrorMsgCodes.PHONE_IS_BLANK;
		} else if (phone.trim().length() < 10) {
			return ErrorMsgCodes.PHONE_INVALID;
		} else if (!(phone.matches("[0-9]{3}[-][0-9]{3}[-][0-9]{4}+"))) {
			return ErrorMsgCodes.PHONE_INVALID;
		}

		return "";
	}

	/*
	 * 
	 * Bank Details Validation
	 * 
	 * 
	 */

	public String validateBankDetails(String bank, String accNo, String ssn, String personId) {
		if (bank == null || bank.trim().length() == 0) {
			return ErrorMsgCodes.BANK_NAME_IS_BLANK;
		}

		if (accNo == null || accNo.trim().length() == 0) {
			return ErrorMsgCodes.ACCOUNT_NUMBER_IS_BLANK;
		}

		if (personId == null || personId.trim().length() == 0) {
			return ErrorMsgCodes.PERSON_ID_IS_BLANK;
		}

		if (ssn == null || ssn.trim().length() == 0) {
			return ErrorMsgCodes.SSN_IS_BLANK;
		} else if (!(ssn.matches("[0-9]{3}[-][0-9]{2}[-][0-9]{4}+"))) {
			return ErrorMsgCodes.SSN_INVALID;
		}

		return "";
	}

}
