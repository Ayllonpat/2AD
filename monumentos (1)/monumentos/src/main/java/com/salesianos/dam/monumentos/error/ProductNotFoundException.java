package com.salesianos.dam.monumentos.error;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id){
        super("No hay ningún monumento con ese ID: %d".formatted(id));
    }

    public ProductNotFoundException(String msg) {
        super(msg);
    }

    public ProductNotFoundException(){
        super("No hay monumentos con esos requisitos de búsqueda");
    }
}
