package com.salesianostriana.dam.data.dto;

import com.salesianostriana.dam.data.model.Producto;

public record GetProductoDto(
        Long id,
        String nombre,
        double precio,
        GetCategoriaDto categoria
) {

    public static GetProductoDto of(Producto p) {
        return new GetProductoDto(
                p.getId(),
                p.getNombre(),
                p.getPrecioVenta(),
                GetCategoriaDto.of(p.getCategoria())
        );
    }

}
