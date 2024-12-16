package com.salesianos.dam.alumnos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    private Long id;
    private String tipoVia;
    private String linea1;
    private String linea2;
    private Long cp;
    private String poblacion;
    private String provincia;

}
