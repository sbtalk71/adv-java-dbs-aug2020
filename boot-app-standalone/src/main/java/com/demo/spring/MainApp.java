package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.services.EmpService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpService service = (EmpService) ctx.getBean("es");

		String response = service.registerEmp(100, "Shantanu", "Hyderabad", 21000);
		System.out.println(response);

	}

}
