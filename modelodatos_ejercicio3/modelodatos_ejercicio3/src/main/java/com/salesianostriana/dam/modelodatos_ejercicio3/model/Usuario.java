package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {

    @Id
    @GeneratedValue
    private Long idUsuario;

    private String nombre;

    @Column(length = 11)
    private String numTarjeta;

    @Column(length = 4)
    private String pin;

    private double saldo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Uso> listaUsos = new ArrayList();

    public void addUso(Uso uso) {
        uso.setUsuario(this);
        listaUsos.add(uso);
    }

    public void removeUso(Uso uso) {
        listaUsos.remove(uso);
        uso.setUsuario(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Usuario usuario = (Usuario) o;
        return getIdUsuario() != null && Objects.equals(getIdUsuario(), usuario.getIdUsuario());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
