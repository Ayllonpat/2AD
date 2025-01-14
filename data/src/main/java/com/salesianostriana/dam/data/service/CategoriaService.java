package com.salesianostriana.dam.data.service;

import com.salesianostriana.dam.data.dto.EditCategoriaCmd;
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

    public Categoria save (EditCategoriaCmd nuevo) {
        return categoriaRepository.save(Categoria.builder(

        ).nombreCategoria(nuevo.nombreCategoria()).build());
    }

    public Categoria edit(EditCategoriaCmd editCategoriaCmd, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombreCategoria(editCategoriaCmd.nombreCategoria());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}
