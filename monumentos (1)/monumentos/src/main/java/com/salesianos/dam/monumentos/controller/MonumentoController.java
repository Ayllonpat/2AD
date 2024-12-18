package com.salesianos.dam.monumentos.controller;

import com.salesianos.dam.monumentos.model.Monumento;
import com.salesianos.dam.monumentos.service.MonumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monumento")
public class MonumentoController {

    @Autowired
    private MonumentoService monumentoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Monumento>> mostrarLista(){
        return new ResponseEntity<>(monumentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> mostrarMonumentoPorId(@PathVariable("id")Long id){
        Optional<Monumento> optionalMonumento = monumentoService.findById(id);
        if (optionalMonumento.isPresent()) {
            Monumento monumento = optionalMonumento.get();
            return new ResponseEntity<Monumento>(monumento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Monumento> crear(@RequestBody Monumento monumento) {

        return new ResponseEntity<>(monumentoService.guardar(monumento), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editar(@PathVariable Long id, @RequestBody Monumento cambio) {

        Optional<Monumento> optionalMonumento = monumentoService.findById(id);

        if(optionalMonumento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Monumento>(monumentoService.editar(id, cambio), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id) {

        if (monumentoService.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        monumentoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
