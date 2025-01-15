package com.salesianostriana.dam.ejercicioSergio.utils;

import com.salesianostriana.dam.ejercicioSergio.model.Estudiante;
import com.salesianostriana.dam.ejercicioSergio.model.InformacionAdicional;
import com.salesianostriana.dam.ejercicioSergio.repository.EstudianteRepositorio;
import com.salesianostriana.dam.ejercicioSergio.repository.InformacionAdicionalRepositorio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final EstudianteRepositorio estudianteRepositorio;
    private final InformacionAdicionalRepositorio informacionAdicionalRepositorio;

    @PostConstruct
    public void init(){

        Estudiante e = Estudiante.builder()
                .nombre("Maria")
                .apellidos("Alonso")
                .curso("1A")
                .edad(18)
                .build();

        InformacionAdicional iA = InformacionAdicional.builder()
                .dni("67883203z")
                .direccion("Calle Virgen de Lujan")
                .email("a@a.com")
                .build();

        e.aniadirInformacionAdicional(iA);

        informacionAdicionalRepositorio.save(iA);
        estudianteRepositorio.save(e);

        estudianteRepositorio.findAll().forEach(System.out::println);
    }
}
