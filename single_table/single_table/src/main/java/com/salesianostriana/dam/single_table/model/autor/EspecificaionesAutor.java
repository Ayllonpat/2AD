package com.salesianostriana.dam.single_table.model.autor;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "AutorId")
@Getter
@Setter
public class EspecificaionesAutor extends Autor {

    private int edad;
    private String apellidos;

}
