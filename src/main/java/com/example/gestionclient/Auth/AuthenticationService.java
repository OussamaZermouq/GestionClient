package com.example.gestionclient.Auth;

import com.example.gestionclient.Configuration.JwtService;
import com.example.gestionclient.Model.ROLE;
import com.example.gestionclient.Model.User;
import com.example.gestionclient.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(ROLE.USER)
                .build();
        repository.save(user);
        var jwttoken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwttoken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
           request.getEmail(),
           request.getPassword()
        ));
        //if we get to this point it means that the authentication has been validated
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwttoken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwttoken).build();
    }
}
