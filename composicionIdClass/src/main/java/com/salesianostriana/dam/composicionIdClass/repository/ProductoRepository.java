package com.salesianostriana.dam.composicionIdClass.repository;

import com.salesianostriana.dam.composicionIdClass.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
