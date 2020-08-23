package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.services.EmpService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		EmpService service = (EmpService) ctx.getBean("empService");

		String response = service.registerEmp(100, "Shantanu", "Hyderabad", 21000);
		System.out.println(response);

	}

}
