package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Repository
@Transactional
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public String save(Emp e) {
		if(findById(e.getEmpId())!=null) {
		return "Emp is already available in DB";
		}else {
			em.persist(e);
			return "Emp saved in DB";
		}
	}

	@Override
	public Emp findById(int id) {
		Emp emp = em.find(Emp.class, id);
		if (emp != null) {
			return emp;
		} else {
			return null;
			//throw new RuntimeException("Emp Not Found with given ID " + id);
		}

	}

	@Override
	public List<Emp> findAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp update(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

}
