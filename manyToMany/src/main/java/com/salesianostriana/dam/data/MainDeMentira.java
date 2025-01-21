package com.salesianostriana.dam.data;

import com.salesianostriana.dam.data.model.Categoria;
import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repository.CategoriaRepository;
import com.salesianostriana.dam.data.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    /*@PostConstruct
    public void init(){
        Producto p = Producto.builder()
                .nombre("Cerveza")
                .build();

        Categoria c = Categoria.builder()
                .nombreCategoria("Bebidas")
                .build();

        p.aniadirCategoria(c);

        productoRepository.save(p);
        categoriaRepository.save(c);

        productoRepository.findAll().forEach(System.out::println);
    }*/

}
