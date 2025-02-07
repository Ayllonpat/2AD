package com.salesianostriana.dam.PruebaSecurity.controller;

import com.salesianostriana.dam.PruebaSecurity.model.EntidadTask;
import com.salesianostriana.dam.PruebaSecurity.service.EntidadTaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entidad")
@AllArgsConstructor
public class EntidadTaskController {

    public final EntidadTaskService entidadTaskService;

    @GetMapping("/")
    public List<EntidadTask> findAll(){
        return entidadTaskService.findAll();
    }

    public EntidadTask findById(Long id){
        return entidadTaskService.findById(id);
    }

    public EntidadTask save(EntidadTask entidadTask){
        return entidadTaskService.save(entidadTask);
    }

}
