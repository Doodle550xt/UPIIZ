package com.upiiz.paqueteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.paqueteria.entities.Ciudad;
import com.upiiz.paqueteria.repositories.CiudadRepository;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> getAllCiudades() {
        return (List<Ciudad>) ciudadRepository.findAll();
    }

    public Ciudad getCiudadByCodigo(String codigo) {
        return ciudadRepository.findById(codigo).orElse(null);
    }

    public Ciudad addCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public Ciudad updateCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public void deleteCiudad(String codigo) {
        ciudadRepository.deleteById(codigo);
    }
}