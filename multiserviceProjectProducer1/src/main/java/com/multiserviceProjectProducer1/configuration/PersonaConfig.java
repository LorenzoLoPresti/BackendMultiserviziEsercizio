package com.multiserviceProjectProducer1.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.multiserviceProjectProducer1.model.Persona;

@Configuration
public class PersonaConfig {

	
	@Bean
	@Scope("prototype")
	public Persona creaPersonaFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		return Persona.builder()
				.nome(fake.name().fullName())
				.username(fake.name().username())
				.email(fake.internet().emailAddress())
				.cellulare(fake.phoneNumber().cellPhone())
				.build();
	}
	
}
