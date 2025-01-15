package com.salesianostriana.dam.ejercicioSergio.repository;

import com.salesianostriana.dam.ejercicioSergio.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
