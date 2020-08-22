package com.demo.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManyToOneMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Dept dept = em.find(Dept.class, 30);
			Emp e1 = new Emp(118, "Abhijit", "Hyderabad", 90000);
			Emp e2 = new Emp(119, "Pradeep", "Hyderabad", 80000);

			e1.setDept(dept);
			e2.setDept(dept);
			em.persist(e1);
			em.persist(e2);
			em.persist(dept);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
