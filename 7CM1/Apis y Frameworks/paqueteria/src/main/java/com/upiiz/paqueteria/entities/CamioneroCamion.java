package com.upiiz.paqueteria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "camionero_camion")
public class CamioneroCamion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RFC_camionero")
    private Camionero camionero;
    
    @ManyToOne
    @JoinColumn(name = "matricula_camion")
    private Camion camion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Camionero getCamionero() {
        return camionero;
    }

    public void setCamionero(Camionero camionero) {
        this.camionero = camionero;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

}
