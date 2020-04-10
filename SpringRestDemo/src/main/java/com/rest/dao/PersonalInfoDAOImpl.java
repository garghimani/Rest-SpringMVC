package com.rest.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rest.util.HibernateUtil;
import com.rest.validation.AccountValidation;
import com.rest.validation.AccountValidationException;
import com.rest.vo.PersonalInfoVOO;



@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO {

	public PersonalInfoDAOImpl() {
		super();
	}

	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside addPersonalInfoDAO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validatePersonalDetails(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender()));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(personalVOO);
			System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : End");
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		PersonalInfoVOO personalVO = null;
		System.out.println("Inside AccountDAO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + firstName);
			personalVO = (PersonalInfoVOO) session.load(PersonalInfoVOO.class, firstName);
			System.out.println(personalVO);
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return personalVO;
	}

	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validateFirstName(personalVOO.getFirstName()));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(personalVOO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + firstName);
			PersonalInfoVOO personalVO = viewPersonalInfo(firstName);
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(personalVO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
