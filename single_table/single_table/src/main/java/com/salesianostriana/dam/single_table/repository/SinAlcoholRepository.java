package com.salesianostriana.dam.single_table.repository;

import com.salesianostriana.dam.single_table.model.bebida.SinAlcohol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinAlcoholRepository extends JpaRepository<SinAlcohol, Long> {
}
