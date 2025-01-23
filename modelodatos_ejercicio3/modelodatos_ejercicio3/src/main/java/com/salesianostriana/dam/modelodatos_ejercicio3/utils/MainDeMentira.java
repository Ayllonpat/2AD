package com.salesianostriana.dam.modelodatos_ejercicio3.utils;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Uso;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.BicicletaRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.EstacionRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.UsoRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final UsuarioRepository usuarioRepository;
    private final UsoRepository usoRepository;
    private final EstacionRepository estacionRepository;
    private final BicicletaRepository bicicletaRepository;

    @PostConstruct
    public void init() {
        Usuario usuario = Usuario.builder()
                .nombre("Usuario 1")
                .saldo(11)
                .pin("1234")
                .numTarjeta("123456")
                .build();
        Uso uso = Uso.builder()
                .fechaFin(LocalDateTime.now())
                .fechaInicio(LocalDateTime.now())
                .coste(2.3)
                .build();
        Estacion estacion = Estacion.builder()
                .nombre("Estacion 1")
                .numero("1A")
                .coordenadas("1-2")
                .capacidad(8)
                .build();
        Bicicleta bicicleta = Bicicleta.builder()
                .marca("ajclña")
                .modelo("CLL")
                .estado("nuevo")
                .build();



        usuario.addUso(uso);
        estacion.addBicicleta(bicicleta);
        bicicleta.addUso(uso);
        uso.setEstacion(estacion);

        usuarioRepository.save(usuario);
        estacionRepository.save(estacion);
        bicicletaRepository.save(bicicleta);
        usoRepository.save(uso);

        usuarioRepository.findAll().forEach(System.out::println);
        usoRepository.findAll().forEach(System.out::println);
    }

}
