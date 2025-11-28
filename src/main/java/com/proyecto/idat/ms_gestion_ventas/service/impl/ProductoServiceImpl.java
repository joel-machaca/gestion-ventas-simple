package com.proyecto.idat.ms_gestion_ventas.service.impl;

import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoResponse;
import com.proyecto.idat.ms_gestion_ventas.entity.Categoria;
import com.proyecto.idat.ms_gestion_ventas.entity.Producto;
import com.proyecto.idat.ms_gestion_ventas.mappers.CategoriaMapper;
import com.proyecto.idat.ms_gestion_ventas.mappers.ProductoMapper;
import com.proyecto.idat.ms_gestion_ventas.repository.CategoriaRepository;
import com.proyecto.idat.ms_gestion_ventas.repository.ProductoRepository;
import com.proyecto.idat.ms_gestion_ventas.service.ProductoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final CategoriaRepository categoriaRepository;
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;

    public ProductoServiceImpl(CategoriaRepository categoriaRepository, ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    // CREAr TERMINADO POR AHORA (POST)
    @Transactional
    @Override
    public ProductoResponse create(ProductoRequest request) {
//        Producto producto =productoMapper.toEntity(request);
//        return productoMapper.toResponse(productoRepository.save(producto));
        // Buscar la categoría
        Categoria categoria = categoriaRepository.findById(request.idCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Crear el producto con el mapper
        Producto producto = productoMapper.toEntity(request);

        // Asignar la categoría
        producto.setCategoria(categoria);

        // Guardar
        productoRepository.save(producto);

        // Retornar respuesta
        return productoMapper.toResponse(producto);
    }
    //FILTRAR POR CATEGORIA


    @Override
    public List<ProductoResponse> findByCategory(Long idCategoria) {
        List<Producto> productos= productoRepository.findProductsByCategory(idCategoria);

        return productos.stream()
                .map(productoMapper::toResponse)
                .toList();
    }

    //PUT
    @Transactional
    @Override
    public ProductoResponse update(Long id, ProductoRequest request) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("el producto no existe o no fue encontrado"));

        // Buscar la nueva categoría
//        Categoria categoria = categoriaRepository.findById(request.idCategoria())
//                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        productoMapper.updateProductoFromResponse(request, producto);

        if (request.idCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(request.idCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            producto.setCategoria(categoria);
        }
        return productoMapper.toResponse(productoRepository.save(producto));

    }

    //GET POR ID TERMINADO
    @Override
    public ProductoResponse findById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("el producto no existe o no fue encontrado"));
        return productoMapper.toResponse(producto);
    }



    //GET LISTADO TERMINADO
    @Override
    public List<ProductoResponse> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toResponse)
                .toList();
    }

    //DELETE terminado no hay nada para hacer
    @Transactional
    @Override
    public void deleteById(Long id) {
        if(!productoRepository.existsById(id)){
            throw new IllegalArgumentException("el producto no existe o no se encuentra");
        }
        productoRepository.deleteById(id);
    }
}
