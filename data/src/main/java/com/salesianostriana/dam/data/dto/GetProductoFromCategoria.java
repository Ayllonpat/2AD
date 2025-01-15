package com.salesianostriana.dam.data.dto;

import com.salesianostriana.dam.data.model.Producto;

public record GetProductoFromCategoria(
        Long id,
        String nombre,
        double precio
) {

    public static GetProductoFromCategoria of (Producto producto){
        return new GetProductoFromCategoria(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecioVenta()
        );
    }

}
