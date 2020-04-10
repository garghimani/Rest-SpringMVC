package com.rest.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.PersonalInfoDAO;
import com.rest.vo.PersonalInfoVOO;

@Service
public class PersonalInfoBOImpl implements PersonalInfoBO {

	@Autowired
	PersonalInfoDAO personDAO;

	
	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws Exception {

		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : Start");
		personDAO.addPersonalInfo(personalVOO);
		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : End");

	}

	
	public PersonalInfoVOO viewPersonalInfo(String firstName) throws Exception {

		PersonalInfoVOO personaVO = personDAO.viewPersonalInfo(firstName);
		return personaVO;
	}

	
	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws Exception {

		personDAO.modifyPersonalInfo(personalVOO);

	}

	
	public void deletePersonalInfo(String firstName) throws Exception {

		personDAO.deletePersonalInfo(firstName);
	}

}
