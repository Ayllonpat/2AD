package com.salesianostriana.dam.data.repository;

import com.salesianostriana.dam.data.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository
        extends JpaRepository<Tag, Long> {
}
