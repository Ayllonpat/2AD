package com.salesianos.dam.alumnos.dto;

import com.salesianos.dam.alumnos.model.Alumno;

public record AlumnoDto(
        String nombre,
        String apellidos,
        String email,
        String curso,
        String direccion
) {


    public static AlumnoDto of(Alumno alumno) {
        return new AlumnoDto(
                alumno.getNombre(),
                alumno.getApelllido1() + alumno.getApellido2(),
                alumno.getEmail(),
                alumno.getCurso().getNombre(),
                alumno.getDireccion().getLinea1()
        );
    }
}
