package com.salesianostriana.dam.composicionIdClass.dto;

import com.salesianostriana.dam.composicionIdClass.model.Categoria;

public record EditProductoDto(
        String nombre,
        Long pvp,
        Long categoriaId
) {
}
