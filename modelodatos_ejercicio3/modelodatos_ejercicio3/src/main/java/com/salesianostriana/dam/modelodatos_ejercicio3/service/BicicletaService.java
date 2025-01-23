package com.salesianostriana.dam.modelodatos_ejercicio3.service;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.BicicletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;

    public List<Bicicleta> findAll() {
        return bicicletaRepository.findAll();
    }

    public Optional<Bicicleta> findById(Long id) {
        return bicicletaRepository.findById(id);
    }

    public Bicicleta edit(Long id, Bicicleta bicicleta) {
        return bicicletaRepository.findById(id).map(b -> {
            b.setMarca(bicicleta.getMarca());
            b.setModelo(bicicleta.getModelo());
            b.setEstado(bicicleta.getEstado());
            return bicicletaRepository.save(b);
        }).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public Bicicleta save(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    public void deleteById(Long id) {
        bicicletaRepository.deleteById(id);
    }
}
