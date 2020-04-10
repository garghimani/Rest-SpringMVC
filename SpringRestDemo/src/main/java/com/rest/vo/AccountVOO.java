package com.rest.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * 
 * 
 * Account Bean
 * 
 * 
 */
@XmlRootElement
@Entity
@Table(name="login")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AccountVOO {
	
	@Id
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String passwd;

	//No Argument Constructor
	public AccountVOO() {
		super();
	}
	
	//Argument Constructor
	public AccountVOO(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
	}

	//Getters
	public String getUserName() {
		return userName;
	}
	
	public String getPasswd() {
		return passwd;
	}

	
	//Setters
	public void setUserName(String userName) {
		this.userName = userName;
	}	

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "AccountVOO [userName=" + userName + ", passwd=" + passwd + "]";
	}

}
