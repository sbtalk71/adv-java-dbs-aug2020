package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Dept dept = session.get(Dept.class, 30);
			Emp e1 = new Emp(114, "Abhijit", "Hyderabad", 90000);
			Emp e2 = new Emp(115, "Pradeep", "Hyderabad", 80000);

			e1.setDept(dept);
			e2.setDept(dept);
			session.save(e1);
			session.save(e2);
			session.update(dept);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
