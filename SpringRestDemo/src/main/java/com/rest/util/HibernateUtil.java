package com.rest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rest.vo.AccountVOO;
import com.rest.vo.BankInfoVOO;
import com.rest.vo.ContactInfoVOO;
import com.rest.vo.PersonalInfoVOO;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static Configuration config;

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			config = new Configuration().configure().addAnnotatedClass(PersonalInfoVOO.class).addAnnotatedClass(ContactInfoVOO.class).addAnnotatedClass(BankInfoVOO.class)
					.addAnnotatedClass(AccountVOO.class);

			ServiceRegistry serviceReg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

			sessionFactory = config.buildSessionFactory(serviceReg);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
