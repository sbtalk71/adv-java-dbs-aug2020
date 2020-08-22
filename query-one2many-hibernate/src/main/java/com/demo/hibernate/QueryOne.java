package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QueryOne {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Dept dept = session.get(Dept.class, 30);
			for(Emp e: dept.getEmpList()) {
				System.out.println(e.getEmpId()+" "+e.getEmpName());
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
