package com.salesianostriana.dam.modelodatos_ejercicio3.controller;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.service.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
@RequiredArgsConstructor
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @GetMapping
    public List<Bicicleta> findAll() {
        return bicicletaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> findById(@PathVariable Long id) {
        return bicicletaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bicicleta save(@RequestBody Bicicleta bicicleta) {
        return bicicletaService.save(bicicleta);
    }

    @PutMapping("/{id}")
    public Bicicleta edit(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
        return bicicletaService.edit(id, bicicleta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bicicletaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
