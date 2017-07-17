package com.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientFromSpring {
	
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(header);
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?q=Bangalore&apikey=8347c28bad72b5fbf4a58c1826e5ca9e", HttpMethod.GET, requestEntity, String.class);
		System.out.println(responseEntity.getBody());
		
	}
}
