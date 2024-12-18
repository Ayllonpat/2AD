package com.salesianos.dam.producto.dto;

import com.salesianos.dam.producto.model.Categoria;
import com.salesianos.dam.producto.model.Producto;

import java.util.List;

public record ProductoDto(
        String nombre,
        double pvp,
        String imagen,
        String categoria)
{

    public static ProductoDto of(Producto producto){
        return new ProductoDto(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().stream().findFirst().get(),
                producto.getCategoria().getNombre()
        );
    }
}
