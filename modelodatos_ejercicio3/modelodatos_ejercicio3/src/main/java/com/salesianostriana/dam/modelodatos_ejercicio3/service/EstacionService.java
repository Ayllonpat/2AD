package com.salesianostriana.dam.modelodatos_ejercicio3.service;

import com.salesianostriana.dam.modelodatos_ejercicio3.dto.EstacionDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;

    public List<Estacion> findAll() {
        List<Estacion> result = estacionRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ninguna estacion");
        return result;
    }

    public Estacion findById(Long id) {

        return estacionRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No existe esa estacion"));
    }

    public Estacion edit(Long id, EstacionDto estacion) {
        return estacionRepository.findById(id).map(old -> {
            old.setNumero(estacion.numero());
            old.setNombre(estacion.nombre());
            old.setCoordenadas(estacion.coordenadas());
            old.setCapacidad(estacion.capacidad());
            return estacionRepository.save(old);
        }).orElseThrow(() -> new RuntimeException("Estacion no encontrada"));
    }

    public Estacion save(EstacionDto nuevo) {
        return estacionRepository.save(Estacion.builder()
                        .numero(nuevo.numero())
                        .coordenadas(nuevo.coordenadas())
                        .capacidad(nuevo.capacidad())
                        .nombre(nuevo.nombre())
                .build());
    }

    public void deleteById(Long id) {
        estacionRepository.deleteById(id);
    }
}
