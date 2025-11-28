package com.proyecto.idat.ms_gestion_ventas.controller;

import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.producto.ProductoResponse;
import com.proyecto.idat.ms_gestion_ventas.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/productos")
public class ProductoRestController {
    private ProductoService productoService;

    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "crear un producto")
    @PostMapping
    public ProductoResponse create(@RequestBody ProductoRequest productoRequest){
        return productoService.create(productoRequest);
    }

    @Operation(summary = "listar todos los productos creados")
    @GetMapping
    public List<ProductoResponse> findAll(){
        return productoService.findAll();
    }

    @Operation(summary = "listar productos mediante una categoria en especifica mediante su id de la categoria")
    @GetMapping("/categoria/{idCategoria}")
    public List<ProductoResponse> findByCategory(@PathVariable Long idCategoria){
        return productoService.findByCategory(idCategoria);
    }

    @Operation(summary = "obtener producto mediante su id")
    @GetMapping("/{id}")
    public ProductoResponse findById(@PathVariable Long id){
        return productoService.findById(id);
    }

    @Operation(summary = "actulizar los campos de un producto mediante su id")
    @PutMapping("/{id}")
    public ProductoResponse update(@PathVariable Long id, @RequestBody ProductoRequest productoRequest){
        return productoService.update(id,productoRequest);
    }

    @Operation(summary = "eliminar un producto mediante su id")
    @DeleteMapping("/{id}")
    public String deteleById(@PathVariable Long id){
        productoService.deleteById(id);
        return "producto eliminado correctamente";
    }
}
