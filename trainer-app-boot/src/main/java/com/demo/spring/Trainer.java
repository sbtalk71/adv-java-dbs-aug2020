package com.demo.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Trainer {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getStudents() {
		return students;
	}

	public void setStudents(Set<String> students) {
		this.students = students;
	}

	private String name;
	private Set<String> students;

	public Trainer() {
		students = new HashSet<>();
		students.add("Amit");
		students.add("Sumit");
		students.add("Pankaj");
		students.add("Pradeep");
		students.add("Dhiraj");
		this.name = "Shantanu";
	}
}
