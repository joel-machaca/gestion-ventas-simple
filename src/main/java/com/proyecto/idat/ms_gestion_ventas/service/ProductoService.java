package com.proyecto.idat.ms_gestion_ventas.service;

import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoResponse;

import java.util.List;

public interface ProductoService
{
    ProductoResponse create(ProductoRequest request);
    ProductoResponse update(Long id, ProductoRequest request);
    ProductoResponse findById(Long id);
    List<ProductoResponse> findAll();
    List<ProductoResponse> findByCategory(Long idCategoria);
    void deleteById(Long id);

}
