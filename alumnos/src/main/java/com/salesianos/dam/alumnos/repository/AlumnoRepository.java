package com.salesianos.dam.alumnos.repository;

import com.salesianos.dam.alumnos.model.Alumno;
import com.salesianos.dam.alumnos.model.Alumno;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class AlumnoRepository {

    private HashMap<Long, Alumno> alumnos = new HashMap<>();

    public Alumno add(Alumno alumno){
        alumnos.put(alumno.getId(), alumno);
        return alumno;
    }

}
