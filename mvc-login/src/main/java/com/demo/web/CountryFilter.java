package com.demo.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CountryFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String country = request.getParameter("country");
		HttpServletRequest hReq = (HttpServletRequest) request;
		String method = hReq.getMethod();
		if (method.equals("GET")) {
			
			chain.doFilter(request, response);
		} else {
			if (country.equalsIgnoreCase("india")) {
				chain.doFilter(request, response);
			} else {
				response.getWriter().write("<h2>You are not from India, but from " + country + " </h2>");
			}

		}
	}

}
