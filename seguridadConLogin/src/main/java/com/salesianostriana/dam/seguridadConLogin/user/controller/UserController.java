package com.salesianostriana.dam.seguridadConLogin.user.controller;

import com.salesianostriana.dam.seguridadConLogin.user.dto.CreateUserRequest;
import com.salesianostriana.dam.seguridadConLogin.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    public ResponseEntity<?> registrer(@RequestBody CreateUserRequest)

}
