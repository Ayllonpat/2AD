package com.salesianostriana.dam.data.controller;

import com.salesianostriana.dam.data.dto.EditCategoriaCmd;
import com.salesianostriana.dam.data.dto.GetCategoriaWithProducto;
import com.salesianostriana.dam.data.dto.GetProductoFromCategoria;
import com.salesianostriana.dam.data.model.Categoria;
import com.salesianostriana.dam.data.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping()
    public List<GetCategoriaWithProducto> getAll() {
        return categoriaService.findAll().stream().map(GetCategoriaWithProducto::of).toList();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody EditCategoriaCmd nuevaCategoria) {


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(nuevaCategoria));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody EditCategoriaCmd aEditar,
                          @PathVariable Long id) {

        return categoriaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
