package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestPostClient {

	public static void main(String[] args) {
		
		RestTemplate rt=new RestTemplate();
		
		//1. create the header
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		Emp emp=new Emp(204, "Kallu", "Delhi", 87000);
		
		HttpEntity requestEntity=new HttpEntity<>(emp,headers);
		
		ResponseEntity<String> response1=rt.exchange("http://localhost:8080/emp/save", HttpMethod.POST, requestEntity, String.class);

		System.out.println(response1.getBody());
	}

}
