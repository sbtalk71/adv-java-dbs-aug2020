package com.demo.hibernate.query;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.demo.hibernate.Emp;

@SuppressWarnings("unchecked")
public class CriteriaQuery1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			
			List<Emp> empList = session.createCriteria(Emp.class)
								.add(Restrictions.between("empId", 103, 115))
								.add(Restrictions.ilike("empName", "A", MatchMode.START)).list();
			
			for (Emp e : empList) {
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
