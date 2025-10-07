package com.upiiz.restaurante.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.restaurante.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}