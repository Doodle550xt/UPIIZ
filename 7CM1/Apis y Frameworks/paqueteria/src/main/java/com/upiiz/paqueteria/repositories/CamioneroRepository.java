package com.upiiz.paqueteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.paqueteria.entities.Camionero;

@Repository
public interface CamioneroRepository extends CrudRepository<Camionero, String> {
}