package com.salesianostriana.dam.jwt.security.security.jwt.login;

import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LogInTokenService {

    private final LogInTokenRepository logInTokenRepository;
    private final UserRepository userRepository;

    @Value("$jwt.logIn.duration")
    private int durationInMinutes;

    public LogInToken create(User user){
        return logInTokenRepository.save(
                LogInToken.builder()
                        .user(user)
                        .expireAt(Instant.now().plusSeconds(durationInMinutes*60))
                        .build()
        );
    }

    public LogInToken verify(LogInToken logInToken){
        
    }

    /*public LogInToken verifyAccount(String token){
        return token;
    }*/

}
