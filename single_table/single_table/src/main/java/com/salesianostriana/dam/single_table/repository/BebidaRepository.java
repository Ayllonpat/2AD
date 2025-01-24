package com.salesianostriana.dam.single_table.repository;

import com.salesianostriana.dam.single_table.model.bebida.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {


    @Query("""
            select b
            from Bebida b
            where type(b) = ConAlcohol
            """)
    List<Bebida> conAlcohol();




}
