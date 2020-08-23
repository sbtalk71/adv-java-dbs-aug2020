package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class MockEmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {

		return "Mock : Emp saved with id " + e.getEmpId();
	}

}
