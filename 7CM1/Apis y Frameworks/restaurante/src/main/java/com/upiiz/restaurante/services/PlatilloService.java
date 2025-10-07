package com.upiiz.restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.restaurante.entities.Platillo;
import com.upiiz.restaurante.repositories.PlatilloRepository;

@Service
public class PlatilloService {

    private final PlatilloRepository platilloRepository;

    public PlatilloService(PlatilloRepository platilloRepository) {
        this.platilloRepository = platilloRepository;
    }

    public List<Platillo> getAllPlatillos() {
        return (List<Platillo>) platilloRepository.findAll();
    }

    public Platillo getPlatilloById(Long id) {
        return platilloRepository.findById(id).orElse(null);
    }

    public Platillo addPlatillo(Platillo platillo) {
        return platilloRepository.save(platillo);
    }

    public Platillo updatePlatillo(Platillo platillo) {
        return platilloRepository.save(platillo);
    }

    public void deletePlatillo(Long id) {
        platilloRepository.deleteById(id);
    }
}
