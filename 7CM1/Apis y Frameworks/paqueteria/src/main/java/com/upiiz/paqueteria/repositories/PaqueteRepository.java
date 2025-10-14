package com.upiiz.paqueteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.paqueteria.entities.Paquete;

@Repository
public interface PaqueteRepository extends CrudRepository<Paquete, String> {
}