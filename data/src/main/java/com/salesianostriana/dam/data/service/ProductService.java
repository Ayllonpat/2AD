package com.salesianostriana.dam.data.service;

import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll(){
        //obtener todos los productos si la lista esta vacia lanzo excepcion

        List<Producto> result = productoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No se ha encontrado ningun producto");
        return result;

    }

    public Producto findById (Long id){
        return  productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con esta id"));
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto edit(Producto producto, Long id){
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.getNombre());
                    old.setDescription(producto.getDescription());
                    old.setPrecioVenta(producto.getPrecioVenta());
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID:"+ id));
    }

     public void delete(Long id){
        productoRepository.deleteById(id);
     }

}
