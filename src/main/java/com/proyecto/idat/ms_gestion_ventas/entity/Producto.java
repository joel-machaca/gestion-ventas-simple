package com.proyecto.idat.ms_gestion_ventas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idProducto;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(name = "precioventa", nullable = false)
    private Double precioVenta;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;

}
