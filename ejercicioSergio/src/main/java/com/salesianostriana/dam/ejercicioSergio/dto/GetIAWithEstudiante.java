package com.salesianostriana.dam.ejercicioSergio.dto;

import com.salesianostriana.dam.ejercicioSergio.model.InformacionAdicional;

public record GetIAWithEstudiante(
        String dni,
        String telefono,
        String email,
        String direccion

) {
    public static GetIAWithEstudiante of(InformacionAdicional informacionAdicional){
        return new GetIAWithEstudiante(
          informacionAdicional.getDni(),
                informacionAdicional.getEmail(),
          informacionAdicional.getTelefono(),
                informacionAdicional.getEmail()


        );
    }
}
