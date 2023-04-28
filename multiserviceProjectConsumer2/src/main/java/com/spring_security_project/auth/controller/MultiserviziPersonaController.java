package com.spring_security_project.auth.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/personae")
public class MultiserviziPersonaController {

	@GetMapping("/data1")
	public ResponseEntity<?> getStringa() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data1";
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		return response;
	}
	
	@GetMapping("/data2")
	@PreAuthorize("hasRole('ADMIN')")
	public String getLista() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data2";
//		Object response = rt.getForObject(url, Object.class);
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		return response.getBody();
	}
	
	@GetMapping("/data3")
	public Object getListaJson() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data3";
		Object response = rt.getForObject(url, Object.class);
	
		return response;
	}
}
