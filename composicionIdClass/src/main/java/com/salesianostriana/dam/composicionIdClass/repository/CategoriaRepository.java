package com.salesianostriana.dam.composicionIdClass.repository;

import com.salesianostriana.dam.composicionIdClass.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
