package com.salesianostriana.dam.PruebaSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EntidadTask {

    @Id
    Long id;

    String title;

}
