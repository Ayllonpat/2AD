package com.salesianostriana.dam.data.controller;

import com.salesianostriana.dam.data.dto.EditProductoCmd;
import com.salesianostriana.dam.data.dto.GetProductoDto;
import com.salesianostriana.dam.data.service.ProductService;
import com.salesianostriana.dam.data.repository.ProductoRepository;
import com.salesianostriana.dam.data.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productoService;

    @GetMapping
    public List<GetProductoDto> getAll() {
        return productoService.findAll()
                .stream()
                .map(GetProductoDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody EditProductoCmd nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        productoService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Producto edit(@RequestBody EditProductoCmd aEditar,
                         @PathVariable Long id) {
        return productoService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
