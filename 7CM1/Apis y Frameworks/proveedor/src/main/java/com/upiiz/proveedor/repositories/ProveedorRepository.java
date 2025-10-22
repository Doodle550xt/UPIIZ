package com.upiiz.proveedor.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.upiiz.proveedor.entities.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

}
