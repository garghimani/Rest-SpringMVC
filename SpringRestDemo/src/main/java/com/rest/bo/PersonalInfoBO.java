package com.rest.bo;

import com.rest.vo.PersonalInfoVOO;

public interface PersonalInfoBO {

	void addPersonalInfo(PersonalInfoVOO personalVOO) throws Exception;

	PersonalInfoVOO viewPersonalInfo(String firstName) throws Exception;

	void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws Exception;

	void deletePersonalInfo(String firstName) throws Exception;

}