package com.salesianostriana.dam.data.dto;

import com.salesianostriana.dam.data.model.Producto;

import java.util.List;

public record EditCategoriaCmd(
        String nombreCategoria,
        List<Producto> productos
) {
}
