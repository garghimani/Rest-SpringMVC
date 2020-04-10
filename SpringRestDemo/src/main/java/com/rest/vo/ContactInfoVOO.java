package com.rest.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@Table(name="contactdetails")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ContactInfoVOO {
	
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;	
	@Column(name="phone")
	private String phone;
	@Id
	@Column(name="personid")
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
