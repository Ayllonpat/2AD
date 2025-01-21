package com.salesianostriana.dam.composicionIdClass.utils;

import com.salesianostriana.dam.composicionIdClass.model.Categoria;
import com.salesianostriana.dam.composicionIdClass.model.Producto;
import com.salesianostriana.dam.composicionIdClass.model.Profesor;
import com.salesianostriana.dam.composicionIdClass.repository.CategoriaRepository;
import com.salesianostriana.dam.composicionIdClass.repository.CursoOnlineRepository;
import com.salesianostriana.dam.composicionIdClass.repository.ProductoRepository;
import com.salesianostriana.dam.composicionIdClass.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    private final ProfesorRepository profesorRepository;
    private final CursoOnlineRepository cursoOnlineRepository;

    @PostConstruct
    public void init(){
        Producto p = Producto.builder()
                .nombre("Cerveza")
                .pvp(11.3)
                .build();

        Categoria c = Categoria.builder()
                .nombre("Bebidas")
                .build();

        Categoria c1 = Categoria.builder()
                .nombre("Alcohol")
                .build();

        Profesor pro = Profesor.builder()
                .nombre("Luismi")
                .build();


        productoRepository.save(p);
        categoriaRepository.save(c1);
        categoriaRepository.save(c);
        p.aniadirCategoria(c);
        c.aniadirCategoria(c1);

        productoRepository.save(p);
        categoriaRepository.save(c1);
        categoriaRepository.save(c);

        productoRepository.findAll().forEach(System.out::println);
    }

}
