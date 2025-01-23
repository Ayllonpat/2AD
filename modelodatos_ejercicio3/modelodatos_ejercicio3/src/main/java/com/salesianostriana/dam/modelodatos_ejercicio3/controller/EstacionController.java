package com.salesianostriana.dam.modelodatos_ejercicio3.controller;

import com.salesianostriana.dam.modelodatos_ejercicio3.dto.EstacionDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;
import com.salesianostriana.dam.modelodatos_ejercicio3.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estaciones")
@RequiredArgsConstructor
public class EstacionController {

    private final EstacionService estacionService;

    @GetMapping
    public List<EstacionDto> findAll() {
        return estacionService.findAll().stream().map(EstacionDto::of).toList();
    }

    @GetMapping("/{id}")
    public EstacionDto findById(@PathVariable Long id){
        return EstacionDto.of(estacionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Estacion> save(@RequestBody EstacionDto estacion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estacionService.save(estacion));
    }

    @PutMapping("/{id}")
    public Estacion edit(@PathVariable Long id,
                         @RequestBody EstacionDto aEdiar) {
        return estacionService.edit(id, aEdiar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
