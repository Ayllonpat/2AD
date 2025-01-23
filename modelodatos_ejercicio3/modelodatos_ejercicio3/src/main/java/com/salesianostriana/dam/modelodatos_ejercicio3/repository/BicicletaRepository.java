package com.salesianostriana.dam.modelodatos_ejercicio3.repository;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {


    List<Bicicleta> findByMarca(String marca);

}
