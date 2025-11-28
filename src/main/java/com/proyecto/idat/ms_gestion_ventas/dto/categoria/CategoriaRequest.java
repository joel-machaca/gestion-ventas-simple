package com.proyecto.idat.ms_gestion_ventas.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record CategoriaRequest(
        @NotBlank
        @Size(min = 2,max = 100, message = "el nombre debe tener entre 2 a 100 caracteres")
        String nombre
)
{
}
