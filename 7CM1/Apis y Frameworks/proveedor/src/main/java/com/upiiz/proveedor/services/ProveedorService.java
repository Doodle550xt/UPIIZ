package com.upiiz.proveedor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.proveedor.entities.Proveedor;
import com.upiiz.proveedor.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> getAllProveedores() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor addProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
