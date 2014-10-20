package com.shanda.linglong.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Email_remindTest {
	private static ApplicationContext ctx;
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testAdd() {
		Email_send er = new Email_send();
		er.setEmail_id(2);
		er.setReceive_id("1");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(er);
		session.getTransaction().commit();
	}
}
