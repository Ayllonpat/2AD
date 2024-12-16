package com.salesianos.dam.monumentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 2)
    private String codigo;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String loc;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 2000)
    private String descripcion;

    @Column(nullable = false)
    private String url;

}
