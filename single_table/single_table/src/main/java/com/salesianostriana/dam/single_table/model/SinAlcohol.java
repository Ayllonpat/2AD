package com.salesianostriana.dam.single_table.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="sin_alcohol")
@Getter
@Setter
public class SinAlcohol extends Bebida{

    public double precioSinAlcohol(){
        return getPrecio();
    }

}
