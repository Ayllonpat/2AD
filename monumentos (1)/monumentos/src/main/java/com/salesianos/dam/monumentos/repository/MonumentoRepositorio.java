package com.salesianos.dam.monumentos.repository;

import com.salesianos.dam.monumentos.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepositorio extends JpaRepository<Monumento, Long> {
}
