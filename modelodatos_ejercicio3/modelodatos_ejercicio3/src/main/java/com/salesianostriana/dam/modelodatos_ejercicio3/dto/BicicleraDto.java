package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;

public record BicicleraDto(
        String  marca,
        String modelo,
        String estado
) {
    public static BicicleraDto of(Bicicleta bicicleta){
        return new BicicleraDto(
                bicicleta.getMarca(),
                bicicleta.getModelo(),
                bicicleta.getEstado()
        );
    }
}
