package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		// Greeting gr=(Greeting)ctx.getBean("greeter");

		Greeting gr = ctx.getBean(Greeting.class);
		System.out.println(gr.getMessage().getMessage());

		Greeting gr1 = (Greeting) ctx.getBean("greeter");

		System.out.println(gr == gr1);

		Greeting gr2 = (Greeting) ctx.getBean("greeter");
	}

}
