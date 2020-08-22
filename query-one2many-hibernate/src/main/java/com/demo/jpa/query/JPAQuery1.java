package com.demo.jpa.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.hibernate.Emp;

@SuppressWarnings("unchecked")
public class JPAQuery1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqldb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createQuery("select e from Emp e");

			// Query<Emp> query = session.createQuery("from Emp e where e.empId between 105
			// and 115 and e.empName like 'A%'");

			// Query<Emp> query = session.createQuery("select e from Emp e where e.empId
			// between 105 and 115 and e.empName like 'A%'");

			List<Emp> empList = query.getResultList();

			for (Emp e : empList) {
				System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
			}

			List<Emp> empList1 = query.getResultList();

			for (Emp e : empList1) {
				System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
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
