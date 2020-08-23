package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class MockEmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {

		return "Mock : Emp saved with id " + e.getEmpId();
	}

}
