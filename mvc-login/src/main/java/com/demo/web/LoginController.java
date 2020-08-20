package com.demo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("user");
		String password = req.getParameter("password");

		LoginModule lm=new LoginModule();
		String response=lm.authenticate(userName, password);
		
			RequestDispatcher rd = req.getRequestDispatcher("/"+response+".jsp");
			req.setAttribute("name", userName);
			rd.forward(req, resp);
	

	}
}
