package com.proyecto.idat.ms_gestion_ventas.dto.producto;

public record ProductoResponse (Long idProducto,
                                String nombre,
                                Double precioVenta,
                                Integer stock,
                                String categoria
                                )
{
}
