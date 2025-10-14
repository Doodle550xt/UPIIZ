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

import com.upiiz.paqueteria.entities.CamioneroCamion;
import com.upiiz.paqueteria.services.CamioneroCamionService;

@RestController
@RequestMapping("/api/v1/conducciones")
public class CamioneroCamionController {

    private final CamioneroCamionService camioneroCamionService;

    public CamioneroCamionController(CamioneroCamionService camioneroCamionService) {
        this.camioneroCamionService = camioneroCamionService;
    }

    @GetMapping
    public ResponseEntity<List<CamioneroCamion>> getAllConducciones() {
        return ResponseEntity.ok(camioneroCamionService.getAllConducciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamioneroCamion> getConduccionById(@PathVariable Long id) {
        CamioneroCamion relacion = camioneroCamionService.getConduccionById(id);
        if (relacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(relacion);
    }

    @PostMapping
    public ResponseEntity<CamioneroCamion> createConduccion(@RequestBody CamioneroCamion camioneroCamion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camioneroCamionService.addConduccion(camioneroCamion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamioneroCamion> updateConduccion(@PathVariable Long id, @RequestBody CamioneroCamion camioneroCamion) {
        camioneroCamion.setId(id);
        return ResponseEntity.ok(camioneroCamionService.updateConduccion(camioneroCamion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConduccion(@PathVariable Long id) {
        camioneroCamionService.deleteConduccion(id);
        return ResponseEntity.noContent().build();
    }
}