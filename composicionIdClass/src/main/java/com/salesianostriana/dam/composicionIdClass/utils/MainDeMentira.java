package com.salesianostriana.dam.composicionIdClass.utils;

import com.salesianostriana.dam.composicionIdClass.model.Categoria;
import com.salesianostriana.dam.composicionIdClass.model.Producto;
import com.salesianostriana.dam.composicionIdClass.repository.CategoriaRepository;
import com.salesianostriana.dam.composicionIdClass.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void init(){
        Producto p = Producto.builder()
                .nombre("Cerveza")
                .pvp((long) 11.3)
                .build();

        Categoria c = Categoria.builder()
                .nombre("Bebidas")
                .build();

        Categoria c1 = Categoria.builder()
                .nombre("Alcohol")
                .build();

        p.aniadirCategoria(c);
        c.aniadirCategoria(c1);

        categoriaRepository.save(c1);
        categoriaRepository.save(c);
        productoRepository.save(p);

        productoRepository.findAll().forEach(System.out::println);
    }

}
