package com.upiiz.paqueteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.paqueteria.entities.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, String> {
}