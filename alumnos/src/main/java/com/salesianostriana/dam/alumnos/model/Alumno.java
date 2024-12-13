package com.salesianostriana.dam.alumnos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre;
    private String apelllido1;
    private String apellido2;
    private String telefono;
    private String email;
    private String direccion;
    private String curso;

}
