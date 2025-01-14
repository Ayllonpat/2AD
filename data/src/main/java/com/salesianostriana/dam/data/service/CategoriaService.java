package com.salesianostriana.dam.data.service;

import com.salesianostriana.dam.data.model.Categoria;
import com.salesianostriana.dam.data.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ninguna categoria");
        return result;
    }

    public Categoria findById (Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(("No existe esa categoria")));
    }

}
