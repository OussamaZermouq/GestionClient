package com.example.gestionclient;

import com.example.gestionclient.Auth.AuthenticationService;
import com.example.gestionclient.Auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.example.gestionclient.Model.ROLE.ADMIN;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GestionClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionClientApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        };
    }
}
