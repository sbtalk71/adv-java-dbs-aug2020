package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init called....");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.write("<h1>Greetings from First Servlet</h1>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroyed the servlet, Bye bye...");
	}
}
