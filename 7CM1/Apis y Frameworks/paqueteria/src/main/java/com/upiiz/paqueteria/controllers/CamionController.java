package com.upiiz.paqueteria.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.paqueteria.entities.Camion;
import com.upiiz.paqueteria.services.CamionService;

@RestController
@RequestMapping("/api/v1/camiones")
public class CamionController {

    private final CamionService camionService;

    public CamionController(CamionService camionService) {
        this.camionService = camionService;
    }

    @GetMapping
    public ResponseEntity<List<Camion>> getAllCamiones() {
        return ResponseEntity.ok(camionService.getAllCamiones());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Camion> getCamionByMatricula(@PathVariable String matricula) {
        Camion camion = camionService.getCamionByMatricula(matricula);
        if (camion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(camion);
    }

    @PostMapping
    public ResponseEntity<Camion> createCamion(@RequestBody Camion camion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camionService.addCamion(camion));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Camion> updateCamion(@PathVariable String matricula, @RequestBody Camion camion) {
        camion.setMatricula(matricula);
        return ResponseEntity.ok(camionService.updateCamion(camion));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteCamion(@PathVariable String matricula) {
        camionService.deleteCamion(matricula);
        return ResponseEntity.noContent().build();
    }
}