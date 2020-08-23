package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("user")String user, @RequestParam("password")String pass) {
		ModelAndView mv = new ModelAndView();
		if (user.equals(pass)) {
			mv.setViewName("success");
			mv.addObject("name", user);
		} else {
			mv.setViewName("failure");
		}
		return mv;
	}
}
