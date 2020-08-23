package com.demo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service("es")
public class EmpService {

	@Autowired
	@Qualifier("mockJdbcEmpDaoImpl")
	private EmpDao dao;

	/*
	 * public void setDao(EmpDao dao) { this.dao = dao; }
	 */

	public String registerEmp(int id, String name, String loc, double sal) {
		System.out.println(dao.getClass().getName());
		String resp = dao.save(new Emp(id, name, loc, sal));
		return resp;
	}
}
