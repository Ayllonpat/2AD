package com.salesianostriana.dam.jwt.security.security.exceptionHandling;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
