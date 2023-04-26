package com.multiserviceProjectProducer1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiserviceProjectProducer1.model.Persona;
import com.multiserviceProjectProducer1.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired PersonaRepository repo;
	
	public List<Persona> trovaTuttePersonae() {
		return (List<Persona>) repo.findAll();
	}
	
	public Persona trovaPersona(Long id) {
		return repo.findById(id).get();
	}
	
}
