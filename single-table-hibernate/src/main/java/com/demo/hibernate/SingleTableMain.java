package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SingleTableMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Person p1 = new Person();
			p1.setName("Shantanu");

			Employee e1 = new Employee();
			e1.setName("Pramod");
			e1.setSalary(78000);

			TraineeEmp t1 = new TraineeEmp();
			t1.setName("Raju");
			t1.setSalary(56000);
			t1.setPerformance("Satisfactory");

			session.save(p1);
			session.save(e1);
			session.save(t1);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
			sf.close();
		}

	}

}
