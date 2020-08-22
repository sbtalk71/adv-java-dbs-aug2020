package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Dept dept=session.get(Dept.class, 30);
			dept.getEmpList().add(new Emp(114, "Abhijit", "Hyderabad", 90000));
			dept.getEmpList().add(new Emp(115, "Pradeep", "Hyderabad", 80000));
			
			session.update(dept);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
