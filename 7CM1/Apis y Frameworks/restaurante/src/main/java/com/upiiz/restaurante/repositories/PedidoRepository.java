package com.upiiz.restaurante.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.restaurante.entities.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
