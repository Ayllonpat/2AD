package com.salesianostriana.dam.ejercicioSergio.dto;

import com.salesianostriana.dam.ejercicioSergio.model.Estudiante;

public record GetEstudianteFromIA(
        String nombre,
        String apellidos,
        int edad,
        String curso
) {
    public static GetEstudianteFromIA of (Estudiante estudiante){
        return new GetEstudianteFromIA(
                estudiante.getNombre(),
                estudiante.getApellidos(),
                estudiante.getEdad(),
                estudiante.getCurso()
        );
    }
}
