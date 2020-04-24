package com.prakash.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.prakash.model.CustomerOrder;

public class JPATest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction etx = em.getTransaction();

	public static void main(String[] args) {
		CustomerOrder c = new CustomerOrder();

		c.setDiscount(9);
		c.setLastUpdate(new Date());
		c.setSatus('A');
		c.setShipmentInfo("Shipped");
		try {
			etx.begin();
			em.persist(c);
			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
