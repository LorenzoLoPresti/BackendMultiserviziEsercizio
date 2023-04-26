package com.multiserviceProjectProducer1.runner;

import java.util.Iterator;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.multiserviceProjectProducer1.model.Persona;
import com.multiserviceProjectProducer1.repository.PersonaRepository;

@Component
public class PersonaRunner implements ApplicationRunner {

	@Autowired ObjectProvider<Persona> persona;
	@Autowired PersonaRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		//crea4Personae();
	}
	
	private void crea4Personae() {
		for (int i = 0; i < 4; i++) {
			repo.save(persona.getObject());
		}
	}

}
