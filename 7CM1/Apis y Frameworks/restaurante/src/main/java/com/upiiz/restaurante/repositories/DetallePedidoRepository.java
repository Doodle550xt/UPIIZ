package com.upiiz.restaurante.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.restaurante.entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
