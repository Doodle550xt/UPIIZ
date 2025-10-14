package com.upiiz.paqueteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.paqueteria.entities.Paquete;
import com.upiiz.paqueteria.repositories.PaqueteRepository;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public List<Paquete> getAllPaquetes() {
        return (List<Paquete>) paqueteRepository.findAll();
    }

    public Paquete getPaqueteByCodigo(String codigo) {
        return paqueteRepository.findById(codigo).orElse(null);
    }

    public Paquete addPaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public Paquete updatePaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public void deletePaquete(String codigo) {
        paqueteRepository.deleteById(codigo);
    }
}