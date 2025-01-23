package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bicicleta {

    @Id
    @GeneratedValue
    private Long idBicicleta;

    private String marca;

    private String modelo;

    private String estado;

    @ManyToOne()
    @ToString.Exclude
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta", fetch = FetchType.EAGER)
    @Builder.Default
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    public void addUso(Uso uso) {
        uso.setBicicleta(this);
        this.usos.add(uso);
    }

    public void removeUso(Uso uso){
        this.usos.remove(uso);
        uso.setBicicleta(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return getIdBicicleta() != null && Objects.equals(getIdBicicleta(), bicicleta.getIdBicicleta());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
