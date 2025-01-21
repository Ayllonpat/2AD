package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
    @Id
    @GeneratedValue
    private Long idUsuario;

    private String nombre;

    @Column(length = 11)
    private String numTarjeta;

    @Column(length = 4)
    private String pin;

    private double saldo;
}
