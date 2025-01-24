package com.salesianostriana.dam.single_table.model.empleado;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

    @Id
    private long id;
    private String nombre;

}
