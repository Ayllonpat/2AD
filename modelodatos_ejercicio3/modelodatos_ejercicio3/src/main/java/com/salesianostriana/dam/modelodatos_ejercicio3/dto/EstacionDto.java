package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;

public record EstacionDto(
        String numero,
        String nombre,
        String coordenadas,
        int capacidad
) {
    public static EstacionDto of(Estacion estacion){
        return new EstacionDto(
          estacion.getNumero(),
          estacion.getNombre(),
                estacion.getCoordenadas(),
                estacion.getCapacidad()
        );
    }
}
