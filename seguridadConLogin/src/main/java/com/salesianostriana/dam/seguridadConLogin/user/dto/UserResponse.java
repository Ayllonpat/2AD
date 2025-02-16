package com.salesianostriana.dam.seguridadConLogin.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.dam.seguridadConLogin.user.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token
) {

    public static UserResponse of (User user) {
        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    public static UserResponse of (User user, String token) {
        return new UserResponse(user.getId(), user.getUsername(), token);
    }

}
