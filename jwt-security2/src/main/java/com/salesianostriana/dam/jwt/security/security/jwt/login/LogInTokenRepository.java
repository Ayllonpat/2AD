package com.salesianostriana.dam.jwt.security.security.jwt.login;

import com.salesianostriana.dam.jwt.security.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LogInTokenRepository extends JpaRepository<LogInToken, UUID> {

    Optional<User> findByEmail(String email);

}
