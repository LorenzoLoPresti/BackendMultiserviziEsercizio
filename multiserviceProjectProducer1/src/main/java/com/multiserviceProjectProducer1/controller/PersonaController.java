package com.multiserviceProjectProducer1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiserviceProjectProducer1.model.Persona;
import com.multiserviceProjectProducer1.service.PersonaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app")
public class PersonaController {

	@Autowired PersonaService service;
	
	@GetMapping("/data1")
	public String getStringa() {
		return "Esercizio1: stringa.";
	}
	
	@GetMapping("/data2")
	public String getPersonae(){
		return service.trovaTuttePersonae().toString();
	}
	
	@GetMapping("/data3")
	public ResponseEntity<?> getPersonaeJson(){
		return new ResponseEntity<>(service.trovaTuttePersonae(), HttpStatus.OK);
	}
	
}
