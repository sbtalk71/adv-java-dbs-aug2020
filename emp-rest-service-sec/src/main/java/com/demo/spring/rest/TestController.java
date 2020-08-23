package com.demo.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//@RequestMapping(path="/greet/{name}",method = RequestMethod.GET)
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable("name") String user) {
		return user+", Hello from Spring REST";
	}
}
