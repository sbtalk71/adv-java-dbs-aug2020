package com.demo.jpa.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



@SuppressWarnings("unchecked")
public class NamedJPAJoinQuery {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {

			Query query = em
					.createNamedQuery("sql-join");

			List<Object[]> empList = query.getResultList();
			for (Object[] e : empList) {
				String name = (String) e[0];
				double salary = (Double) e[1];
				String dname = (String) e[2];
				String manager = (String) e[3];
				System.out.println(name + " " + salary + " " + dname + " " + manager);
			}
			// tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
