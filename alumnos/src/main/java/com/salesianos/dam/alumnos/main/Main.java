package com.salesianos.dam.alumnos.main;

import com.salesianos.dam.alumnos.dto.AlumnoDto;
import com.salesianos.dam.alumnos.model.Alumno;
import com.salesianos.dam.alumnos.model.Curso;
import com.salesianos.dam.alumnos.model.Direccion;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Main {
    @PostConstruct
    public void init() {
        Curso curso = Curso.builder().id(1L).nombre("a").aula("a").tutor("a").tipo("a").build();
        Direccion direccion = Direccion.builder().id(2L).cp(11111L).linea1("a").linea2("a").poblacion("a").provincia("a").build();
        Alumno alumno = Alumno.builder().curso(curso).direccion(direccion).nombre("Maria").apelllido1("a").build();

        System.out.println(AlumnoDto.of(alumno));

    }
}
