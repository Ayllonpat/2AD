package com.salesianostriana.dam.single_table.model.bebida;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value="con_alcohol")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@ToString(callSuper = true)
public class ConAlcohol extends Bebida{

    public double precioConAlcohol(){
        return getPrecio()+1;
    }

}
