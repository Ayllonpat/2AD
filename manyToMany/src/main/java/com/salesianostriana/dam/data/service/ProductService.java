package com.salesianostriana.dam.data.service;

import com.salesianostriana.dam.data.dto.EditProductoCmd;
import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repository.CategoriaRepository;
import com.salesianostriana.dam.data.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

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

    public Producto save(EditProductoCmd nuevo) {
        return productoRepository.save(Producto.builder()
                .nombre(nuevo.nombre())
                .precioVenta(nuevo.precio())
                //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                .categoria(categoriaRepository.findById(nuevo.categoriaId()).orElse(null))
                .description(nuevo.descripcion())
                .build());
    }

    public Producto edit(EditProductoCmd editProductoCmd, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(editProductoCmd.nombre());
                    old.setDescription(editProductoCmd.descripcion());
                    old.setPrecioVenta(editProductoCmd.precio());
                    //old.setCategoria(categoriaRepository.getReferenceById(editProductoCmd.categoriaId()));
                    old.setCategoria(categoriaRepository.findById(editProductoCmd.categoriaId()).orElse(null));
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));

    }

     public void delete(Long id){
        productoRepository.deleteById(id);
     }

}
