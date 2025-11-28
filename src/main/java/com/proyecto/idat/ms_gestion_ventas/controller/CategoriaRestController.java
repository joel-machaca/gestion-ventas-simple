package com.proyecto.idat.ms_gestion_ventas.controller;

import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaRequest;
import com.proyecto.idat.ms_gestion_ventas.dto.categoria.CategoriaResponse;
import com.proyecto.idat.ms_gestion_ventas.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")

public class CategoriaRestController
{
    private final CategoriaService categoriaService;

    public CategoriaRestController(CategoriaService categoriaService)
    {
        this.categoriaService = categoriaService;
    }

    @Operation(summary = "crear una categoria")
    @PostMapping
    public CategoriaResponse create(@RequestBody CategoriaRequest categoriaRequest)
    {
        return categoriaService.create(categoriaRequest);
    }

    @Operation(summary = "listado de todas las categorias creadas")
    @GetMapping
    public List<CategoriaResponse> findAll()
    {
        return categoriaService.findAll();
    }


    @Operation(summary = "actualizar los campos de una categoria por id")
    @PutMapping("/{id}")
    public CategoriaResponse update(@PathVariable Long id, @RequestBody CategoriaRequest categoriaRequest)
    {
        return categoriaService.update(id,categoriaRequest);
    }

    @Operation(summary = "eliminar una categoria por id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        categoriaService.deleteById(id);
    }


    @Operation(summary = "obtener una categoria en especifica mediante su id")
    @GetMapping("/{id}")
    public CategoriaResponse findById(@PathVariable Long id)
    {
        return categoriaService.findById(id);
    }

}
