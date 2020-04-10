package com.rest.interfaces;

/*
 * 
 * Error Message Codes
 * 
 * */
public interface ErrorMsgCodes {

	// Login Error Codes
	String USER_ID_NULL = "UserName Required<br>";
	String PASSWORD_NULL = "Password Required <br>";
	public static final String USER_ID_INVALID = "Invalid UserName. for eg: Ab_2-1<br>";
	public static final String PWD_INVALID = "Invalid Password. for eg: He_34-llo@123<br>";

	// Personal details Error Codes
	public static final String FIRST_NAME_IS_BLANK = "First Name is blank<br>";
	public static final String FIRST_NAME_INVALID = "First Name must start with a letter. "
			+ "It can contain only letters, numbers, spaces, hyphens(-) and underscores(_).<br/>";
	public static final String MIDDLE_NAME_IS_BLANK = "Middle Name is blank<br>";
	public static final String MIDDLE_NAME_INVALID = "Middle Name must start with a letter. "
			+ "It can contain only letters, numbers, spaces, hyphens(-) and underscores(_).<br/>";
	public static final String LAST_NAME_IS_BLANK = "Last Name is blank<br>";
	public static final String LAST_NAME_INVALID = "Last Name must start with a letter. "
			+ "It can contain only letters, numbers, spaces, hyphens(-) and underscores(_).<br/>";

	// Contact details Error Codes
	public static final String ADDRESS_IS_BLANK = "Address is blank<br>";
	public static final String CITY_IS_BLANK = "City is blank<br>";
	public static final String STATE_IS_BLANK = "State is blank<br>";
	public static final String COUNTRY_IS_BLANK = "Country is blank<br>";
	public static final String PHONE_IS_BLANK = "Phone Number is blank<br>";
	public static final String PERSON_ID_IS_BLANK = "First Name is blank<br>";
	public static final String PHONE_INVALID = "Please specify the phone number in the format (000-000-0000).<br/>";

	//Bank Details Error Codes
	public static final String BANK_NAME_IS_BLANK = "Bank Name is blank<br>";
	public static final String ACCOUNT_NUMBER_IS_BLANK = "Account Number is blank<br>";
	public static final String SSN_IS_BLANK = "SSN is blank<br>";
	public static final String SSN_INVALID = "SSN should be in the format (000-00-0000).<br/>";

	public static final String HOME_PAGE = "/jsp/home.jsp";
}
