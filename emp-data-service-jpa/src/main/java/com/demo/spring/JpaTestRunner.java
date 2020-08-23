package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
public class JpaTestRunner implements CommandLineRunner {

	@Autowired
	private EmpDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(dao.save(new Emp(203, "Ramu", "Hyderabad", 89000)));
		
		//System.out.println(emp.getEmpId()+" "+emp.getEmpName());
	}

}
