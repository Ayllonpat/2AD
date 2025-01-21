package com.salesianostriana.dam.composicionIdClass.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long idCursoOnline;

    private String nombre;

    private double puntuacion;

    @ManyToOne
    @ToString.Exclude
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

    public void addProfesor (Profesor profesor){
        setProfesor(profesor);
        profesor.getCursoOnline().add(this);
    }

    public void deleteProfesor(Profesor profesor){
        profesor.getCursoOnline().remove(this);
        setProfesor(null);
    }

    public void addVideo(Video video) {

        video.setCursoOnline(this);
        this.videos.add(video);
    }

    public void removeVideo(Video video){
        videos.remove(video);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CursoOnline that = (CursoOnline) o;
        return getIdCursoOnline() != null && Objects.equals(getIdCursoOnline(), that.getIdCursoOnline());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
