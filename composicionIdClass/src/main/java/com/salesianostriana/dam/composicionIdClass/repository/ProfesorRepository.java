package com.salesianostriana.dam.composicionIdClass.repository;

import com.salesianostriana.dam.composicionIdClass.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
