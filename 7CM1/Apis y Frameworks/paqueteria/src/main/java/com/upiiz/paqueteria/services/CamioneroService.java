package com.upiiz.paqueteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.paqueteria.entities.Camionero;
import com.upiiz.paqueteria.repositories.CamioneroRepository;

@Service
public class CamioneroService {

    private final CamioneroRepository camioneroRepository;

    public CamioneroService(CamioneroRepository camioneroRepository) {
        this.camioneroRepository = camioneroRepository;
    }

    public List<Camionero> getAllCamioneros() {
        return (List<Camionero>) camioneroRepository.findAll();
    }

    public Camionero getCamioneroByRfc(String rfc) {
        return camioneroRepository.findById(rfc).orElse(null);
    }

    public Camionero addCamionero(Camionero camionero) {
        System.err.println("ID:");
        System.err.println(camionero.getRFC());
        return camioneroRepository.save(camionero);
    }

    public Camionero updateCamionero(Camionero camionero) {
        // En un update real, podrías añadir lógica para verificar si el RFC existe
        return camioneroRepository.save(camionero);
    }

    public void deleteCamionero(String rfc) {
        camioneroRepository.deleteById(rfc);
    }
}