package com.demo.spring;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestGetClient {

	public static void main(String[] args) {
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> response=rt.getForEntity("http://localhost:8080/emp/find/1044", String.class);
		System.out.println(response.getBody());
		
		//1. create the header
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity requestEntity=new HttpEntity<>(headers);
		
		ResponseEntity<String> response1=rt.exchange("http://localhost:8080/emp/find/104", HttpMethod.GET, requestEntity, String.class);

		System.out.println(response1.getBody());
		
		ResponseEntity<Emp> response2=rt.exchange("http://localhost:8080/emp/find/104", 
														HttpMethod.GET, requestEntity, Emp.class);
		
		Emp emp=response2.getBody();
		System.out.println(emp.getEmpId()+" "+emp.getEmpName());

		ResponseEntity<String> response3=rt.getForEntity("http://localhost:8080/emp/", String.class);
		System.out.println(response3.getBody());
		
		
		ResponseEntity<List<Emp>> empListResp=rt.exchange("http://localhost:8080/emp/", HttpMethod.GET,requestEntity, new ParameterizedTypeReference<List<Emp>>() {});
	
		for(Emp e: empListResp.getBody()) {
			System.out.println(e.getEmpId()+" "+e.getEmpName());
		}
	}

}
