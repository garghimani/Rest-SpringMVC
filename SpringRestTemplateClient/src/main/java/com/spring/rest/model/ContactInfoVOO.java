package com.spring.rest.model;

public class ContactInfoVOO {

	private String address;
	private String city;
	private String state;
	private String country;	
	private String phone;
	private String personID;
	
	public ContactInfoVOO() {
		super();
	}
	
	public ContactInfoVOO(String address, String city, String state, String country, String phone, String personID) {
		
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.personID = personID;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	@Override
	public String toString() {
		return "ContactInfoVOO [address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", phone=" + phone + ", personID=" + personID + "]";
	}	

}
