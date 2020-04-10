package com.spring.rest.model;


public class BankInfoVOO {	

	private String bankName;
	private String accountNumber;
	private String ssn;
	private String personId;
	
	public BankInfoVOO() {
		super();
	}

	public BankInfoVOO(String bankName, String accountNumber, String ssn, String personId) {
		
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ssn = ssn;
		this.personId = personId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "BankInfoVOO [bankName=" + bankName + ", accountNumber=" + accountNumber + ", ssn=" + ssn + ", personId="
				+ personId + "]";
	}

}
