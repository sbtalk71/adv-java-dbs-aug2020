package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Address;
import com.demo.hibernate.Child;
import com.demo.hibernate.Emp;

public class HibernateColl {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Emp emp = session.get(Emp.class, 102);

			emp.getChildren().add(new Child("Ankit", "male", 23));
			emp.getChildren().add(new Child("Jeevan", "male", 27));
			emp.getChildren().add(new Child("Mala", "female", 17));
			emp.getChildren().add(new Child("Chandi", "male", 12));
			session.update(emp);
			// session.flush();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
