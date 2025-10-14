package com.upiiz.paqueteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.paqueteria.entities.CamioneroCamion;
import com.upiiz.paqueteria.repositories.CamioneroCamionRepository;

@Service
public class CamioneroCamionService {

    private final CamioneroCamionRepository camioneroCamionRepository;

    public CamioneroCamionService(CamioneroCamionRepository camioneroCamionRepository) {
        this.camioneroCamionRepository = camioneroCamionRepository;
    }

    public List<CamioneroCamion> getAllConducciones() {
        return (List<CamioneroCamion>) camioneroCamionRepository.findAll();
    }

    public CamioneroCamion getConduccionById(Long id) {
        return camioneroCamionRepository.findById(id).orElse(null);
    }
    
    public CamioneroCamion addConduccion(CamioneroCamion camioneroCamion) {
        return camioneroCamionRepository.save(camioneroCamion);
    }

    public CamioneroCamion updateConduccion(CamioneroCamion camioneroCamion) {
        // La actualización de una conducción puede ser para cambiar las FKs
        return camioneroCamionRepository.save(camioneroCamion);
    }

    public void deleteConduccion(Long id) {
        camioneroCamionRepository.deleteById(id);
    }
}