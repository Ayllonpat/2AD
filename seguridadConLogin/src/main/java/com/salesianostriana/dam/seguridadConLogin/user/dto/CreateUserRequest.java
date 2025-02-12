package com.salesianostriana.dam.seguridadConLogin.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record CreateUserRequest(
        String username,
        String password,
        String verifyPassword,
        String avatar,
        String fullName){

}
