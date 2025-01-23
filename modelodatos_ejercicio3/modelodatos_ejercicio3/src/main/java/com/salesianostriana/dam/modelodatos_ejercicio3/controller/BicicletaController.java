package com.salesianostriana.dam.modelodatos_ejercicio3.controller;

import com.salesianostriana.dam.modelodatos_ejercicio3.dto.BicicleraDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.service.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
@RequiredArgsConstructor
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @GetMapping
    public List<BicicleraDto> findAll() {
        return bicicletaService.findAll().stream().map(BicicleraDto::of).toList();
    }

    @GetMapping("/{id}")
    public BicicleraDto findById(@PathVariable Long id){
        return BicicleraDto.of(bicicletaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Bicicleta> save(@RequestBody BicicleraDto bicicleta) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bicicletaService.save(bicicleta));
    }

    @PutMapping("/{id}")
    public Bicicleta edit(@PathVariable Long id,
                          @RequestBody BicicleraDto aEdiar) {
        return bicicletaService.edit(id, aEdiar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        bicicletaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
