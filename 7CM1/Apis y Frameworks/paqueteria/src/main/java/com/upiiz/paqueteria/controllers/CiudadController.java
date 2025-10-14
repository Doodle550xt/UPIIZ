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

import com.upiiz.paqueteria.entities.Ciudad;
import com.upiiz.paqueteria.services.CiudadService;

@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> getAllCiudades() {
        return ResponseEntity.ok(ciudadService.getAllCiudades());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Ciudad> getCiudadByCodigo(@PathVariable String codigo) {
        Ciudad ciudad = ciudadService.getCiudadByCodigo(codigo);
        if (ciudad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ciudad);
    }

    @PostMapping
    public ResponseEntity<Ciudad> createCiudad(@RequestBody Ciudad ciudad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.addCiudad(ciudad));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Ciudad> updateCiudad(@PathVariable String codigo, @RequestBody Ciudad ciudad) {
        ciudad.setCodigo(codigo);
        return ResponseEntity.ok(ciudadService.updateCiudad(ciudad));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable String codigo) {
        ciudadService.deleteCiudad(codigo);
        return ResponseEntity.noContent().build();
    }
}