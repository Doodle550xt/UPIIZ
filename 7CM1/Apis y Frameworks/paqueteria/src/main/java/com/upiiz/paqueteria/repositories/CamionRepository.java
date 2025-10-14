package com.upiiz.paqueteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.paqueteria.entities.Camion;

@Repository
public interface CamionRepository extends CrudRepository<Camion, String> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}