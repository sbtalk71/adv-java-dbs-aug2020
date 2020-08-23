package com.demo.spring;

public class Greeting {

	private Message message;
	public Greeting() {
		System.out.println("Greeting Object Created..");
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		System.out.println(" Message set to Greeting Object..");
		this.message = message;
	}

}
