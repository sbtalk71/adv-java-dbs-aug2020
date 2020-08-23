package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestGetClientSec {

	public static void main(String[] args) {
		
		String credentials="james:welcome1";
		String encodedCredentials=new String(Base64.encodeBase64(credentials.getBytes()));
		System.out.println("Encoded Credentials : "+encodedCredentials);
		RestTemplate rt=new RestTemplate();
		
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Basic "+encodedCredentials);
		
		HttpEntity requestEntity=new HttpEntity<>(headers);
		
		ResponseEntity<String> response1=rt.exchange("http://localhost:8080/emp/find/104", HttpMethod.GET, requestEntity, String.class);

		System.out.println(response1.getBody());
		
		
		}
	}


