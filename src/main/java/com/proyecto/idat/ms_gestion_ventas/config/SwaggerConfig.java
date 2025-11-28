package com.proyecto.idat.ms_gestion_ventas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion Ventas",
                description = "Sistema simple para gestionar categorías y productos de una tienda.",
                version = "1.0.0"
        )
)
public class SwaggerConfig {

}
