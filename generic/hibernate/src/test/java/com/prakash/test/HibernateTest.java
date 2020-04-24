package com.prakash.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prakash.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails ud = new UserDetails();
		ud.setUserName("Prakash");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(ud);
		s.getTransaction().commit();
	}
}
