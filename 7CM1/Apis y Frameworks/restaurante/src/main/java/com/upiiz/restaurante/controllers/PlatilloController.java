package com.upiiz.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.upiiz.restaurante.entities.Platillo;
import com.upiiz.restaurante.services.PlatilloService;

@RestController
@RequestMapping("/garufa/public/v1/platillos")
public class PlatilloController {

    @Autowired
    private PlatilloService platilloService;

    public PlatilloController(PlatilloService platilloService) {
        this.platilloService = platilloService;
    }

    @GetMapping
    public ResponseEntity<List<Platillo>> getAllPlatillos() {
        return ResponseEntity.ok(platilloService.getAllPlatillos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platillo> getPlatilloById(@PathVariable Long id) {
        return ResponseEntity.ok(platilloService.getPlatilloById(id));
    }

    @PostMapping
    public ResponseEntity<Platillo> createPlatillo(@RequestBody Platillo platillo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(platilloService.addPlatillo(platillo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Platillo> updatePlatillo(@PathVariable Long id, @RequestBody Platillo platillo) {
        platillo.setId(id);
        return ResponseEntity.ok(platilloService.updatePlatillo(platillo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlatillo(@PathVariable Long id) {
        platilloService.deletePlatillo(id);
        return ResponseEntity.noContent().build();
    }
}
