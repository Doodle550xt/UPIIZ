package com.upiiz.restaurante.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.restaurante.entities.Platillo;

@Repository
public interface PlatilloRepository extends CrudRepository<Platillo, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
