package com.salesianostriana.dam.composicionIdClass.service;

import com.salesianostriana.dam.composicionIdClass.dto.EditProductoDto;
import com.salesianostriana.dam.composicionIdClass.model.Producto;
import com.salesianostriana.dam.composicionIdClass.repository.CategoriaRepository;
import com.salesianostriana.dam.composicionIdClass.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Producto> findAll(){
        List<Producto> result = productoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ningun producto");
        return result;
    }

    public Optional<Producto> findById(Long id){
        Optional<Producto> result = productoRepository.findById(id);
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ningun producto");
        return result;
    }

    public Producto save(EditProductoDto nuevo) {
        return productoRepository.save(Producto.builder()
                .nombre(nuevo.nombre())
                //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                .categoria(categoriaRepository.findById(nuevo.categoriaId()).orElse(null))
                .build());
    }

    public Producto edit(EditProductoDto producto, Long id){
        return productoRepository.findById(id)
                .map(old -> {
                            old.setNombre(producto.nombre());
                            old.setPvp(producto.pvp());
                            old.setCategoria(categoriaRepository.findById(producto.categoriaId()).orElse(null));
                            return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: " + id));
    }

    public void delete(Long id){
        productoRepository.deleteById(id);
    }

}
