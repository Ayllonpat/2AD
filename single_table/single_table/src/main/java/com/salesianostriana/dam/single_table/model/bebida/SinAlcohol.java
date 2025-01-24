package com.salesianostriana.dam.single_table.model.bebida;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value="sin_alcohol")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@ToString(callSuper = true)
public class SinAlcohol extends Bebida{

    public double precioSinAlcohol(){
        return getPrecio();
    }

}
