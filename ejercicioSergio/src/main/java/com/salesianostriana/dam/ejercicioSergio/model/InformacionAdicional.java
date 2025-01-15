package com.salesianostriana.dam.ejercicioSergio.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InformacionAdicional {

    @Id
    private Long idEstudiante;

    @Column
    private String dni;

    @Column
    private String telefono;

    @Column
    private String email;

    @Column
    private String direccion;

    @OneToOne(mappedBy = "informacionAdicional")
    @MapsId
    @ToString.Exclude
    private Estudiante estudiante;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        InformacionAdicional that = (InformacionAdicional) o;
        return getIdEstudiante() != null && Objects.equals(getIdEstudiante(), that.getIdEstudiante());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
