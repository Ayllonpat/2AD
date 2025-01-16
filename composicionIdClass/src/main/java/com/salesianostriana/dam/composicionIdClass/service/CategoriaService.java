package com.salesianostriana.dam.composicionIdClass.service;

import com.salesianostriana.dam.composicionIdClass.dto.EditCategoriaDto;
import com.salesianostriana.dam.composicionIdClass.model.Categoria;
import com.salesianostriana.dam.composicionIdClass.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
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

    public Categoria save (EditCategoriaDto nuevo) {
        return categoriaRepository.save(Categoria.builder(

        ).nombre(nuevo.nombre()).build());
    }

    public Categoria edit(EditCategoriaDto editCategoriaCmd, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editCategoriaCmd.nombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}
