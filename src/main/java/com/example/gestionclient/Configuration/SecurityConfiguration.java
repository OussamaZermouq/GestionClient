package com.example.gestionclient.Configuration;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.gestionclient.Model.ROLE.ADMIN;
import static com.example.gestionclient.Model.ROLE.USER;
import static org.springframework.http.HttpMethod.*;


@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity

public class SecurityConfiguration {

    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    //toutes les urls qui ne sont pas securise eg {home, help, contact,...}
    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**"};
    private final LogoutHandler logoutHandler;

    @Bean
    public LogoutHandler getLogoutHandler() {
        return logoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers(WHITE_LIST_URL)
                        .permitAll()
                        .requestMatchers("/api/v1/client/**").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers(GET, "/api/v1/client/**").hasAnyAuthority(ADMIN.name(), USER.name())
                        .requestMatchers(POST, "/api/v1/client/**").hasAnyAuthority(ADMIN.name())
                        .requestMatchers(PUT, "/api/v1/client/**").hasAnyAuthority(ADMIN.name())
                        .requestMatchers(DELETE, "/api/v1/client/**").hasAnyAuthority(ADMIN.name())
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(
                        logout-> logout.logoutUrl("api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext())
                                )
                );


        return httpSecurity.build();
    }
}
