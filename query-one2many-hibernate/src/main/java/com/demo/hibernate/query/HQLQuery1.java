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
public class HQLQuery1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Query<Emp> query = session.createQuery("from Emp");
			query.setCacheable(true);
			query.setCacheRegion("emp-query");
			//Query<Emp> query = session.createQuery("from Emp e where e.empId between 105 and 115 and e.empName like 'A%'");
			
			//Query<Emp> query = session.createQuery("select e from Emp e where e.empId between 105 and 115 and e.empName like 'A%'");
			
			
			List<Emp> empList = query.getResultList();
			
			for (Emp e : empList) {
				System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
			}
			
			List<Emp> empList1 = query.getResultList();
			
			for (Emp e : empList1) {
				System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
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
