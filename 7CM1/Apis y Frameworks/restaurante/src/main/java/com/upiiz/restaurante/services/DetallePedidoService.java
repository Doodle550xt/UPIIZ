package com.upiiz.restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.restaurante.entities.DetallePedido;
import com.upiiz.restaurante.repositories.DetallePedidoRepository;

@Service
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<DetallePedido> getAllDetalles() {
        return (List<DetallePedido>) detallePedidoRepository.findAll();
    }

    public DetallePedido getDetalleById(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public DetallePedido addDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido updateDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public void deleteDetalle(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}
