package com.salesianostriana.dam.single_table.utils;

import com.salesianostriana.dam.single_table.model.bebida.Bebida;
import com.salesianostriana.dam.single_table.model.bebida.ConAlcohol;
import com.salesianostriana.dam.single_table.model.bebida.SinAlcohol;
import com.salesianostriana.dam.single_table.repository.BebidaRepository;
import com.salesianostriana.dam.single_table.repository.ConAlcoholRepository;
import com.salesianostriana.dam.single_table.repository.SinAlcoholRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final BebidaRepository bebidaRepository;
    private final ConAlcoholRepository conAlcoholRepository;
    private final SinAlcoholRepository sinAlcoholRepository;

    @PostConstruct
    public void init(){

        ConAlcohol bolletin = ConAlcohol.builder()
                .nombre("Botellín fresquito")
                .precio(1.5)
                .build();


        SinAlcohol agua = SinAlcohol.builder()
                .nombre("Agua fresquita")
                .precio(1.0)
                .build();


        bebidaRepository.save(bolletin);
        bebidaRepository.save(agua);


        //bebidaRepository.findAll().forEach(System.out::println);
        bebidaRepository.conAlcohol().forEach(System.out::println);
       // conAlcoholRepository.findAll().forEach(System.out::println);
        //sinAlcoholRepository.findAll().forEach(System.out::println);


    }

}
