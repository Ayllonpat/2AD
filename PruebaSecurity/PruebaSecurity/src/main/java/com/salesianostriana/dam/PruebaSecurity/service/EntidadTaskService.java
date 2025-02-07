package com.salesianostriana.dam.PruebaSecurity.service;

import com.salesianostriana.dam.PruebaSecurity.model.EntidadTask;
import com.salesianostriana.dam.PruebaSecurity.repository.EntidadTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntidadTaskService {

    public final EntidadTaskRepository entidadTaskRepository;

    public EntidadTask findById(Long id){
        return entidadTaskRepository.findById(id).orElse(null);
    }

    public List<EntidadTask> findAll(){
        return entidadTaskRepository.findAll();
    }

    public EntidadTask save(EntidadTask entidadTask){
        return entidadTaskRepository.save(entidadTask);
    }

}
