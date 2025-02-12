package com.salesianostriana.dam.seguridadConLogin.user.service;


import com.salesianostriana.dam.seguridadConLogin.user.dto.CreateUserRequest;
import com.salesianostriana.dam.seguridadConLogin.user.model.User;
import com.salesianostriana.dam.seguridadConLogin.user.model.UserRole;
import com.salesianostriana.dam.seguridadConLogin.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest, EnumSet<UserRole> roles) {
        User user =  User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .avatar(createUserRequest.avatar())
                .fullName(createUserRequest.fullName())
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);
    }

    public User createUserWithUserRole(CreateUserRequest createUserRequest){
        return createUser(createUserRequest, EnumSet.of(UserRole.USER));
    }

}
