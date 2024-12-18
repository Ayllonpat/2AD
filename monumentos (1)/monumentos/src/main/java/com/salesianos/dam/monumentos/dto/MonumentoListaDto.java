package com.salesianos.dam.monumentos.dto;

import com.salesianos.dam.monumentos.model.Monumento;

import java.util.List;

public record MonumentoListaDto(
        Long count,
        List<Monumento> items
) {
    public static MonumentoListaDto of(List<Monumento> items){
        return new MonumentoListaDto((long) items.size(),
                items);
    }

    public List<Monumento> to() {
        return items;
    }
}
