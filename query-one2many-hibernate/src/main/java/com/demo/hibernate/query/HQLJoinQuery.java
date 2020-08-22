package com.demo.hibernate.query;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.hibernate.Emp;

@SuppressWarnings("unchecked")
public class HQLJoinQuery {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Query<Object[]> query = session
					.createQuery("select e.empName,e.salary,d.deptName,d.manager from Dept d inner join d.empList e");

			List<Object[]> empList = query.getResultList();
			for (Object[] e : empList) {
				String name = (String) e[0];
				double salary = (Double) e[1];
				String dname = (String) e[2];
				String manager = (String) e[3];
				System.out.println(name + " " + salary + " " + dname + " " + manager);
			}
			// tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
