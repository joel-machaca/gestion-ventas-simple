package com.proyecto.idat.ms_gestion_ventas.dto.producto;

public record ProductoRequest(
        String nombre,
        Double precioVenta,
        Integer stock,
        Long idCategoria
) {
}
