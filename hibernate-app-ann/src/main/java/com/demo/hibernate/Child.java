package com.demo.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Child {
	private String name;
	private String gender;
	private int age;

	public Child() {
		// TODO Auto-generated constructor stub
	}

	public Child(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " " + gender + " " + age;
	}
}
