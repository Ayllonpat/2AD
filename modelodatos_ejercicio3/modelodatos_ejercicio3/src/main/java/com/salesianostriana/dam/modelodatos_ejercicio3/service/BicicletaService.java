package com.salesianostriana.dam.modelodatos_ejercicio3.service;

import com.salesianostriana.dam.modelodatos_ejercicio3.dto.BicicleraDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.BicicletaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;

    public List<Bicicleta> findAll() {
        List<Bicicleta> result = bicicletaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ninguna bicicleta");
        return result;
    }

    public Bicicleta findById(Long id) {

        return bicicletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe esa bicicleta"));
    }

    public Bicicleta edit(Long id, BicicleraDto bicicleta) {
        return bicicletaRepository.findById(id).map(old -> {
            old.setMarca(bicicleta.marca());
            old.setModelo(bicicleta.modelo());
            old.setEstado(bicicleta.estado());
            return bicicletaRepository.save(old);
        }).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public Bicicleta save(BicicleraDto nuevo) {

        return bicicletaRepository.save(Bicicleta.builder()
                        .marca(nuevo.marca())
                        .modelo(nuevo.modelo())
                        .estado(nuevo.estado())
                .build());
    }

    public void deleteById(Long id) {
        bicicletaRepository.deleteById(id);
    }
}
