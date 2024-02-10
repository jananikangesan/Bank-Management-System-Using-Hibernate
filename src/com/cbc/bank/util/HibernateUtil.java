package com.cbc.bank.util;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static SessionFactory factory;

	static {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		cfg.setProperty("hibernate.connection.url", resourceBundle.getString("db.url"));
		cfg.setProperty("hibernate.connection.username", resourceBundle.getString("db.username"));
		cfg.setProperty("hibernate.connection.password", resourceBundle.getString("db.password"));

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
