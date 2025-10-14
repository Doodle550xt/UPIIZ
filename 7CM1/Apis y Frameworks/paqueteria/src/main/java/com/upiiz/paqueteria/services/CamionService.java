package com.upiiz.paqueteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.paqueteria.entities.Camion;
import com.upiiz.paqueteria.repositories.CamionRepository;

@Service
public class CamionService {

    private final CamionRepository camionRepository;

    public CamionService(CamionRepository camionRepository) {
        this.camionRepository = camionRepository;
    }

    public List<Camion> getAllCamiones() {
        return (List<Camion>) camionRepository.findAll();
    }

    public Camion getCamionByMatricula(String matricula) {
        return camionRepository.findById(matricula).orElse(null);
    }

    public Camion addCamion(Camion camion) {
        return camionRepository.save(camion);
    }

    public Camion updateCamion(Camion camion) {
        return camionRepository.save(camion);
    }

    public void deleteCamion(String matricula) {
        camionRepository.deleteById(matricula);
    }
}