package com.rest.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rest.util.HibernateUtil;
import com.rest.validation.AccountValidation;
import com.rest.validation.AccountValidationException;
import com.rest.vo.BankInfoVOO;

@Repository
public class BankInfoDAOImpl implements BankInfoDAO {

	public void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception {

		System.out.println("BankInfoDAOImpl : addPersonalInfo() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + bankVOO.getBankName());
		allMessages.append(accValidate.validateBankDetails(bankVOO.getBankName(), bankVOO.getAccountNumber(),
				bankVOO.getSsn(), bankVOO.getPersonId()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + bankVOO.getBankName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(bankVOO);
			System.out.println("BankInfoDAOImpl : addPersonalInfo() : End");
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}


	public BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		BankInfoVOO bankVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			bankVO = (BankInfoVOO)session.load(BankInfoVOO.class, firstName);
			System.out.println(bankVO);
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return bankVO;
	}

	public void modifyBankInfo(BankInfoVOO modifybankVOO) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + modifybankVOO.getPersonId());
		allMessages.append(accValidate.validateFirstName(modifybankVOO.getPersonId()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + modifybankVOO.getPersonId());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(modifybankVOO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public void deleteBankInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoVOO bankVO = viewBankInfo(firstName);
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(bankVO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
