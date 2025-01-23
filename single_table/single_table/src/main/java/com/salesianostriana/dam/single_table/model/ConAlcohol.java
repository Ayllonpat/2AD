package com.salesianostriana.dam.single_table.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="con_alcohol")
@Getter
@Setter
public class ConAlcohol extends Bebida{

    public double precioConAlcohol(){
        return getPrecio()+1;
    }

}
