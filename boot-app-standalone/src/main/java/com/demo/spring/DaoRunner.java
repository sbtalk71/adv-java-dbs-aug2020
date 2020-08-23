package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.services.EmpService;

@Component
public class DaoRunner implements CommandLineRunner {

	@Autowired
	EmpService service;

	@Override
	public void run(String... args) throws Exception {
		String response = service.registerEmp(100, "Shantanu", "Hyderabad", 21000);
		System.out.println(response);

	}

}
