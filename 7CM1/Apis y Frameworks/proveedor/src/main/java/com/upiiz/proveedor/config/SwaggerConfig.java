package com.upiiz.proveedor.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info=@Info(
        title="Documentación de la API de Proveedores",
        description="Nos permite gestionar la información del sistema de proveedores",
        // Versión - Funcionalodades menores - Parches
        version="1.0.0",
        contact = @Contact(
            name="Cristian García Nieves",
            url="ninguna.com",
            email="crisgnh01@gmail.com"
        ),
        license=@License(
            name="MINT",
            url="ninguna.com/licencia"
        ),
        termsOfService="ninguna.com/terminos"
    ),
    servers = {
        @Server(url="http://localhost:8080/",description="Servidor de pruebas"),
        @Server(url="https://api.render.com",description = "Servidor de producción")
    }
)
public class SwaggerConfig {
}
