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
public class HQLQueryProj {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Query<Object[]> query = session.createQuery(
					"select e.empId,e.empName from Emp e where e.empId between 105 and 115 and e.empName like 'A%'");

			List<Object[]> empList = query.getResultList();
			for (Object[] e : empList) {
				int id = (Integer) e[0];
				String name = (String) e[1];
				System.out.println(id + " " + name);
			}
			
			System.out.println("--------Pass 2-------");
			Query<EmpData> query1 = session.createQuery(
					"select new com.demo.hibernate.query.EmpData(e.empId,e.empName) from Emp e where e.empId between 105 and 115 and e.empName like 'A%'");

			List<EmpData> empList1 = query1.getResultList();
			for (EmpData e : empList1) {
				
				System.out.println(e.getEmpId() + " " + e.getEmpName());
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
