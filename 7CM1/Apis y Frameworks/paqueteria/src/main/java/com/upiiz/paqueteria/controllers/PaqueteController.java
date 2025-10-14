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

import com.upiiz.paqueteria.entities.Paquete;
import com.upiiz.paqueteria.services.PaqueteService;

@RestController
@RequestMapping("/api/v1/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public ResponseEntity<List<Paquete>> getAllPaquetes() {
        return ResponseEntity.ok(paqueteService.getAllPaquetes());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Paquete> getPaqueteByCodigo(@PathVariable String codigo) {
        Paquete paquete = paqueteService.getPaqueteByCodigo(codigo);
        if (paquete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paquete);
    }

    @PostMapping
    public ResponseEntity<Paquete> createPaquete(@RequestBody Paquete paquete) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paqueteService.addPaquete(paquete));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Paquete> updatePaquete(@PathVariable String codigo, @RequestBody Paquete paquete) {
        paquete.setCodigo(codigo);
        return ResponseEntity.ok(paqueteService.updatePaquete(paquete));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePaquete(@PathVariable String codigo) {
        paqueteService.deletePaquete(codigo);
        return ResponseEntity.noContent().build();
    }
}