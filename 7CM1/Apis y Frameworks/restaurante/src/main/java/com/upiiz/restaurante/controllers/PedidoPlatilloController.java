package com.upiiz.restaurante.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.restaurante.entities.DetallePedido;
import com.upiiz.restaurante.entities.Pedido;
import com.upiiz.restaurante.entities.Platillo;
import com.upiiz.restaurante.services.DetallePedidoService;
import com.upiiz.restaurante.services.PedidoService;
import com.upiiz.restaurante.services.PlatilloService;

@RestController
@RequestMapping("/garufa/public/v1/pedidos/{idPedido}/platillos")
public class PedidoPlatilloController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PlatilloService platilloService;

    @Autowired
    private DetallePedidoService detallePedidoService;

    public PedidoPlatilloController(PedidoService pedidoService, PlatilloService platilloService,
            DetallePedidoService detallePedidoService) {
        this.pedidoService = pedidoService;
        this.platilloService = platilloService;
        this.detallePedidoService = detallePedidoService;
    }

    // Listar platillos de un pedido
    @GetMapping
    public ResponseEntity<List<Platillo>> getPlatillosDePedido(@PathVariable Long idPedido) {
        List<Platillo> platillos = detallePedidoService.getAllDetalles().stream()
                .filter(det -> det.getPedido() != null && det.getPedido().getId().equals(idPedido))
                .map(detalle -> detalle.getPlatillo())
                .collect(Collectors.toList());

        return ResponseEntity.ok(platillos);
    }

    @PostMapping("/{idPlatillo}")
    public ResponseEntity<Void> agregarPlatilloAPedido(@PathVariable Long idPedido, @PathVariable Long idPlatillo) {
        Pedido pedido = pedidoService.getPedidoById(idPedido);
        Platillo platillo = platilloService.getPlatilloById(idPlatillo);

        DetallePedido detalle = new DetallePedido();
        detalle.setPedido(pedido);
        detalle.setPlatillo(platillo);
        detalle.setPrecioActual(platillo.getPrecio());

        detallePedidoService.addDetalle(detalle);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idPlatillo}")
    public ResponseEntity<Void> quitarPlatilloDePedido(@PathVariable Long idPedido, @PathVariable Long idPlatillo) {
        List<DetallePedido> detalles = detallePedidoService.getAllDetalles().stream()
                .filter(det -> det.getPedido() != null && det.getPedido().getId().equals(idPedido) && det.getPlatillo().getId().equals(idPlatillo))
                .collect(Collectors.toList());

        detalles.forEach(detalle -> detallePedidoService.deleteDetalle(detalle.getId()));

        return ResponseEntity.noContent().build();
    }
}
