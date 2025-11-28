package com.proyecto.idat.ms_gestion_ventas.mappers;


import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoResponse;
import com.proyecto.idat.ms_gestion_ventas.entity.Producto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductoMapper
{
    @Mapping(target = "categoria", ignore = true)
    Producto toEntity(ProductoRequest request);

    @Mapping(source = "categoria.nombre", target = "categoria")
    ProductoResponse toResponse(Producto producto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductoFromResponse(ProductoRequest productoRequest, @MappingTarget Producto producto);
}