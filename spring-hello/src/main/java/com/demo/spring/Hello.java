package com.demo.spring;

public class Hello {

	private String message;
	public Hello() {
		System.out.println("Hello Object Created..");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println(" Message set to Hello Object..");
		this.message = message;
	}

}
