package com.proyecto.idat.ms_gestion_ventas.service.impl;

import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaResponse;
import com.proyecto.idat.ms_gestion_ventas.entity.Categoria;
import com.proyecto.idat.ms_gestion_ventas.mappers.CategoriaMapper;
import com.proyecto.idat.ms_gestion_ventas.repository.CategoriaRepository;
import com.proyecto.idat.ms_gestion_ventas.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CategoriaServiceImpl implements CategoriaService
{
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper)
    {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Transactional
    @Override
    public CategoriaResponse create(CategoriaRequest request) {
        Categoria categoria = categoriaMapper.toEntity(request);
        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse update(Long id, CategoriaRequest request) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("La categoría ingresada no existe"));
        categoriaMapper.updateCategoriaFromResponse(request, categoria);
        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }


    @Override
    public CategoriaResponse findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("La categoría ingresada no existe"));
        return categoriaMapper.toResponse(categoria);
    }

    @Override
    public List<CategoriaResponse> findAll() {
       return categoriaRepository.findAll()
               .stream()
               .map(categoriaMapper::toResponse)
               .toList();
    }

    @Transactional
    @Override
    public void deleteById(Long id)
    {
        if(!categoriaRepository.existsById(id))
            throw new IllegalArgumentException("La categoría ingresada no existe");
        categoriaRepository.deleteById(id);

    }
}
