package com.sprintinaction.jpa.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprintinaction.jpa.model.CustomerOrder;

public class JPAPersistance {
	
	@Autowired
	private static EntityManagerFactory emf;
	
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction etx = em.getTransaction();

	public void persistData(CustomerOrder c) {
		try {
			etx.begin();
			em.persist(c);
			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
