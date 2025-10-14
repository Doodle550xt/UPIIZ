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

import com.upiiz.paqueteria.entities.Camionero;
import com.upiiz.paqueteria.services.CamioneroService;

@RestController
@RequestMapping("/api/v1/camioneros")
public class CamioneroController {

    private final CamioneroService camioneroService;

    public CamioneroController(CamioneroService camioneroService) {
        this.camioneroService = camioneroService;
    }
    @GetMapping
    public ResponseEntity<List<Camionero>> getAllCamioneros() {
        return ResponseEntity.ok(camioneroService.getAllCamioneros());
    }

    @GetMapping("/{rfc}")
    public ResponseEntity<Camionero> getCamioneroByRfc(@PathVariable String rfc) {
        Camionero camionero = camioneroService.getCamioneroByRfc(rfc);
        if (camionero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(camionero);
    }
    @PostMapping
    public ResponseEntity<Camionero> createCamionero(@RequestBody Camionero camionero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camioneroService.addCamionero(camionero));
    }

    @PutMapping("/{rfc}")
    public ResponseEntity<Camionero> updateCamionero(@PathVariable String rfc, @RequestBody Camionero camionero) {
        camionero.setRFC(rfc);
        return ResponseEntity.ok(camioneroService.updateCamionero(camionero));
    }

    @DeleteMapping("/{rfc}")
    public ResponseEntity<Void> deleteCamionero(@PathVariable String rfc) {
        camioneroService.deleteCamionero(rfc);
        return ResponseEntity.noContent().build();
    }
}