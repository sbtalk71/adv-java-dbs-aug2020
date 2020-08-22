package com.demo.di.test;

public class Main1 {

	public static void main(String[] args) {
		
		Message message=new Message("Tea Break", "  Break already taken");
		Mail mail= new Mail("abc@gmail.com","xyz@yahoo.com",message);
		
		System.out.println(mail.getMessage().getBody());
		
		
		Mail mail1=new Mail();
		mail1.setFromAddress("abc@gmail.com");
		mail1.setToAddress("xyz@yahoo.com");
		mail1.setMessage(message);
		
		System.out.println(mail1.getMessage().getBody());
		

	}

}
