package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrainerRunner implements CommandLineRunner {

	@Autowired
	private Trainer trainer;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Trainer : "+trainer.getName());
		for(String s: trainer.getStudents()) {
			System.out.println(s);
		}

	}

}
