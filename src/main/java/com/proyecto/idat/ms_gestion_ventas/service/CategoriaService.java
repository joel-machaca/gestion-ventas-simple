package com.proyecto.idat.ms_gestion_ventas.service;

import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaResponse;
import com.proyecto.idat.ms_gestion_ventas.entity.Categoria;

import java.util.List;

public interface CategoriaService
{
    CategoriaResponse create(CategoriaRequest request);
    CategoriaResponse update(Long id, CategoriaRequest request);
    CategoriaResponse findById(Long id);
    List<CategoriaResponse> findAll();
    void deleteById(Long id);
}
