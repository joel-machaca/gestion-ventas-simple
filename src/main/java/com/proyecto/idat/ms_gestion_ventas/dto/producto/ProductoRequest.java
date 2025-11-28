package com.proyecto.idat.ms_gestion_ventas.dto.producto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductoRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String nombre,

        @NotNull(message = "El precio de venta es obligatorio")
        @Positive(message = "El precio debe ser positivo")
        Double precioVenta,

        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock mínimo es 0")
        @Max(value = 1000, message = "El stock máximo es 1000")
        Integer stock,

        @NotNull(message = "La categoría es obligatoria")
        Long idCategoria
) {
}
