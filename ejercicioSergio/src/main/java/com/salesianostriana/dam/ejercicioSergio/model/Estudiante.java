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
@Table(name = "Estudiantes")
@Builder
@ToString
public class Estudiante {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private int edad;

    @Column
    private String curso;

    @OneToOne
    private InformacionAdicional informacionAdicional;

    //hay que crearlos manualmente para borrar y crear la relacion entre ellos
    public void aniadirInformacionAdicional(InformacionAdicional informacionAdicional){

        setInformacionAdicional(informacionAdicional);
        informacionAdicional.setEstudiante(this);

    }

    public void borrarInformacionAdicional(InformacionAdicional informacionAdicional){

        informacionAdicional.setEstudiante(null);
        setInformacionAdicional(null);

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estudiante that = (Estudiante) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
