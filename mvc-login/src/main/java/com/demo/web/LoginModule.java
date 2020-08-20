package com.demo.web;

public class LoginModule {

	public String authenticate(String user, String password) {
		if (user.equals(password)) {
			return "success";
		} else {
			return "failure";
		}
	}
}
