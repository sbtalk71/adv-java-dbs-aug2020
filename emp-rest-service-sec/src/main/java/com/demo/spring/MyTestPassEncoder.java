package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyTestPassEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder enc=new BCryptPasswordEncoder();
		System.out.println(enc.encode("welcome1"));

	}

}
