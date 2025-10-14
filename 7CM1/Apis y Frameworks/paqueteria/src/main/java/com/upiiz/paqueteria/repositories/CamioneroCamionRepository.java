package com.upiiz.paqueteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.paqueteria.entities.CamioneroCamion;

@Repository
public interface CamioneroCamionRepository extends CrudRepository<CamioneroCamion, Long> {
}