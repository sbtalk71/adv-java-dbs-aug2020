package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JoinedTableQuery1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			TraineeEmp t1 = session.get(TraineeEmp.class, 12);
			System.out.println(t1.getPerformance());

			// tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {

			session.close();
			sf.close();
		}

	}

}
