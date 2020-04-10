package com.rest.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rest.util.HibernateUtil;
import com.rest.validation.AccountValidation;
import com.rest.validation.AccountValidationException;
import com.rest.vo.ContactInfoVOO;

@Repository
public class ContactInfoDAOImpl implements ContactInfoDAO {


	public void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception {

		System.out.println("ContactInfoDAOImpl : addContactInfo() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + contactVOO.getAddress());
		allMessages.append(accValidate.validateContactDetails(contactVOO.getAddress(), contactVOO.getCity(),
				contactVOO.getState(), contactVOO.getCountry(), contactVOO.getPhone(), contactVOO.getPersonID()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + contactVOO.getAddress());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(contactVOO);
			System.out.println("ContactInfoDAOImpl : addContactInfo() : End");
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	

	public ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		ContactInfoVOO contactVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			contactVO = (ContactInfoVOO)session.load(ContactInfoVOO.class, firstName);
			System.out.println(contactVO);
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return contactVO;
	}
	

	public void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + contactVO.getPersonID());
		allMessages.append(accValidate.validateFirstName(contactVO.getPersonID()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + contactVO.getPersonID());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(contactVO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	

	public void deleteContactInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoVOO personalVO = viewContactInfo(firstName);
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
