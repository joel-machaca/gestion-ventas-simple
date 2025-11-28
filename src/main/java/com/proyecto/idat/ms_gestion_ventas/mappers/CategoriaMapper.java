package com.proyecto.idat.ms_gestion_ventas.mappers;

import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaResponse;
import com.proyecto.idat.ms_gestion_ventas.entity.Categoria;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoriaMapper
{
    Categoria toEntity(CategoriaRequest request);

    CategoriaResponse toResponse(Categoria categoria);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoriaFromResponse(CategoriaRequest categoriaRequest, @MappingTarget Categoria categoria);
}
