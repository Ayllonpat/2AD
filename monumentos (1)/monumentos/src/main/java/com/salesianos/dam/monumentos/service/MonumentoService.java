package com.salesianos.dam.monumentos.service;

import com.salesianos.dam.monumentos.model.Monumento;
import com.salesianos.dam.monumentos.repository.MonumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MonumentoService {
    @Autowired
    public MonumentoRepositorio monumentoRepositorio;

    public List<Monumento> findAll() {
        return monumentoRepositorio.findAll();
    }

    public Optional<Monumento> findById(Long id){
        return monumentoRepositorio.findById(id);
    }

    public Monumento guardar(Monumento monumento) {

        return monumentoRepositorio.save(monumento);
    }

    public Monumento editar(Long id, Monumento edicion) {

        Monumento antMonumento = monumentoRepositorio.findById(id).orElse(null);

        if(antMonumento != null){

            antMonumento.setLoc(edicion.getLoc());
            antMonumento.setDescripcion(edicion.getDescripcion());
            antMonumento.setCodigo(edicion.getCodigo());
            antMonumento.setNombre(edicion.getNombre());
            antMonumento.setCiudad(edicion.getCiudad());
            antMonumento.setPais(edicion.getPais());
            antMonumento.setUrl(edicion.getUrl());

            return monumentoRepositorio.save(antMonumento);

        }
        return null;
    }

    public void deleteById(Long id) {

        monumentoRepositorio.deleteById(id);
    }
}
