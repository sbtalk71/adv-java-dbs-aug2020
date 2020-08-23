package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpRepository;
import com.demo.spring.entity.Emp;

@Component
public class JpaTestRunner2 implements CommandLineRunner {

	@Autowired
	private EmpRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(repo.getClass().getName());
		Optional<Emp> empOp= repo.findById(203);
		if(empOp.isPresent()) {
			Emp e=empOp.get();
			System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getCity());
		}else {
			System.out.println("Emp not found..");
		}
	}

}
