package com.multiserviceProjectProducer1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multiserviceProjectProducer1.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
