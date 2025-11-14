package com.upiiz.proveedor.controllers;

import java.util.Map;

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

import com.upiiz.proveedor.entities.Proveedor;
import com.upiiz.proveedor.services.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/public/api/v1/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @Operation(summary = "Obtener todos los proveedores", description = "Recupera una lista con todos los proveedores registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de proveedores obtenida correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Proveedor.class), examples = @ExampleObject(value = """
                    [
                    {
                        "id": 1,
                        "nombreEmpresa": "Apple Inc.",
                        "contacto": "Steve Jobs",
                        "telefono": "123 123 1234",
                        "correo": "contacto@apple.com",
                        "pais": "Estados Unidos"
                    },
                    {
                        "id": 2,
                        "nombreEmpresa": "Native Instruments",
                        "contacto": "Mike Shinoda",
                        "telefono": "992 494 1212",
                        "correo": "contacto@nativeinstruments.com",
                        "pais": "Estados Unidos"
                    }
                    ]
                    """))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                        "estado": "Error interno del servidor",
                        "mensaje": "Error al obtener la lista de proveedores"
                        }
                    """)))
    })
    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<?> getAllProveedores() {
        try {
            return ResponseEntity.ok(proveedorService.getAllProveedores());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "estado", "Error interno del servidor", "mensaje", "Error al obtener la lista de proveedores"));
        }
    }

    // Obtener un proveedor por su ID
    @Operation(summary = "Obtener proveedor por ID", description = "Devuelve los datos del proveedor correspondiente al ID especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Proveedor.class))),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "No encontrado",
                            "mensaje": "No se encontró un proveedor con el ID proporcionado"
                        }
                    """))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                        "estado": "Error interno del servidor",
                        "mensaje": "Error al buscar el proveedor"
                        }
                    """)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getProveedorById(@PathVariable Long id) {
        try {
            Proveedor proveedor = proveedorService.getProveedorById(id);
            if (proveedor != null) {
                return ResponseEntity.ok(proveedor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "estado", "No encontrado",
                        "mensaje", "No se encontró un proveedor con el ID proporcionado"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "estado", "Error interno del servidor",
                    "mensaje", "Error al buscar el proveedor"));
        }
    }

    // Crear un nuevo proveedor
    @Operation(summary = "Crear un nuevo proveedor", description = "Crea un proveedor con los datos proporcionados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Proveedor creado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Proveedor.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o incompletos", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                        "estado": "Petición inválida",
                        "mensaje": "Faltan campos requeridos o hay datos con formato incorrecto"
                        }
                    """))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                        "estado": "Error interno del servidor",
                        "mensaje": "Error al crear el proveedor"
                        }
                    """)))
    })
    @PostMapping
    public ResponseEntity<?> addProveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor nuevoProveedor = proveedorService.addProveedor(proveedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "estado", "Petición inválida",
                    "mensaje", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "estado", "Error interno del servidor",
                    "mensaje", "Error al crear el proveedor"));
        }
    }

    // Actualizar un proveedor existente
    @Operation(summary = "Actualizar un proveedor", description = "Actualiza los datos del proveedor especificado por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Proveedor.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "Petición inválida",
                            "mensaje": "Faltan campos o hay datos con formato incorrecto"
                        }
                    """))),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "No encontrado",
                            "mensaje": "No se encontró un proveedor con el ID proporcionado"
                        }
                    """))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "Error interno del servidor",
                            "mensaje": "Error inesperado al actualizar el proveedor"
                        }
                    """)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        try {
            Proveedor proveedorExistente = proveedorService.getProveedorById(id);
            if (proveedorExistente != null) {
                proveedor.setId(id);
                return ResponseEntity.ok(proveedorService.updateProveedor(proveedor));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "estado", "No encontrado",
                        "mensaje", "No se encontró un proveedor con el ID proporcionado"));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "estado", "Petición inválida",
                    "mensaje", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "estado", "Error interno del servidor",
                    "mensaje", "Error inesperado al actualizar el proveedor"));
        }
    }

    // Eliminar un proveedor
    @Operation(summary = "Eliminar un proveedor", description = "Elimina un proveedor existente por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Proveedor eliminado correctamente", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "Proveedor eliminado correctamente",
                            "mensaje": "Se eliminó el proveedor con el ID especificado"
                        }
                    """))),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "No encontrado",
                            "mensaje": "No se encontró un proveedor con el ID especificado"
                        }
                    """))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                        {
                            "estado": "Error interno del servidor",
                            "mensaje": "No se pudo eliminar el proveedor"
                        }
                    """)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable Long id) {
        try {
            Proveedor proveedor = proveedorService.getProveedorById(id);
            if (proveedor != null) {
                proveedorService.deleteProveedor(id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of(
                        "estado", "Proveedor eliminado correctamente",
                        "mensaje", "Se eliminó el proveedor con el ID especificado"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "estado", "No encontrado",
                        "mensaje", "No se encontró un proveedor con el ID especificado"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "estado", "Error interno del servidor",
                    "mensaje", "No se pudo eliminar el proveedor"));
        }
    }
}
