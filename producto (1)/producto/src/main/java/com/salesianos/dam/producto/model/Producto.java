package com.salesianos.dam.producto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
    private String nombre;
    private Long id;
    private String descripcion;
    private List<String> imagenes;
    private Categoria categoria;
    private double pvp;
}
