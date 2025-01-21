package com.salesianostriana.dam.composicionIdClass.model;


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
public class Categoria {

    @Id
    @GeneratedValue
    private Long idCategoria;

    private String nombre;

    @OneToMany(mappedBy = "categoria")
    @ToString.Exclude
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    @OneToOne
    @ToString.Exclude
    private Categoria categoria;

    @OneToOne(mappedBy = "categoria")
    private Categoria categoriaHija;

    public void aniadirCategoria(Categoria categoria){
        setCategoriaHija(categoria);
        categoria.setCategoria(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getIdCategoria() != null && Objects.equals(getIdCategoria(), categoria.getIdCategoria());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
