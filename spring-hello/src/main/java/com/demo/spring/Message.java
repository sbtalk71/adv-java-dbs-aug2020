package com.demo.spring;

public class Message {

	private String message;

	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Message(String message) {
		System.out.println("Message Object created...");
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
