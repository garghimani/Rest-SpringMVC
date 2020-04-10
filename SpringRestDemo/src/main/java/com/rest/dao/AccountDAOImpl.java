package com.rest.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rest.util.HibernateUtil;
import com.rest.validation.AccountValidation;
import com.rest.validation.AccountValidationException;
import com.rest.vo.AccountVOO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	public AccountVOO getLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception {
		
		AccountVOO accVO = null;
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		if (allMessages.length() == 0) {
			//retrieving database record
			//LoginDB loginDB = new LoginDB();
			//accVO = loginDB.getLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
		return accVO;
	}
	
	public void addLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception{
		
		System.out.println("LoginDAO : addLoginDetails() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		System.out.println("BO Messages :"+allMessages.toString());
		if(allMessages.length() == 0) {
			System.out.println("In BO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(accountVO);
			//LoginDB loginDB = new LoginDB();
			//loginDB.addLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
			System.out.println("LoginDAO : addLoginDetails() : End");
			tx.commit();
			session.close();
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
