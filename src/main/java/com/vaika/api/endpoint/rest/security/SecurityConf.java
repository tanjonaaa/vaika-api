package com.vaika.api.endpoint.rest.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConf {
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public AuthenticationManager authenticationManager(
            final AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                        (authorize) -> {
                            authorize
                                    .requestMatchers(OPTIONS, "/**")
                                    .permitAll()
                                    .requestMatchers(GET, "/ping")
                                    .permitAll()
                                    .requestMatchers(GET, "/token")
                                    .permitAll()
                                    .requestMatchers(GET, "/health/db")
                                    .permitAll()
                                    .requestMatchers(GET, "/health/bucket")
                                    .permitAll()
                                    .requestMatchers(GET, "/health/event")
                                    .permitAll()
                                    .requestMatchers(GET, "/health/email")
                                    .permitAll()
                                    .requestMatchers(GET, "/whoami")
                                    .authenticated()
                                    .requestMatchers("/**")
                                    .denyAll();
                        })
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
