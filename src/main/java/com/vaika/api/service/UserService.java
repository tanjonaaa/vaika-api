package com.vaika.api.service;

import com.vaika.api.endpoint.rest.model.Credentials;
import com.vaika.api.model.exception.ForbiddenException;
import com.vaika.api.repository.jpa.UserRepository;
import com.vaika.api.repository.model.User;
import com.vaika.api.service.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
  // TODO: add authenticate method with token generation
  // TODO: add register method with password encoding
  private final JwtService jwtService;
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;

  public String authenticateAndGetToken(Credentials credentials) {
    String email = credentials.getEmail();
    String rawPassword = credentials.getPassword();

    User user =
        repository.findByEmail(email).orElseThrow(() -> new ForbiddenException("Bad credentials"));

    if (!(user.getPassword().equals(passwordEncoder.encode(rawPassword))))
      throw new ForbiddenException("Bad credentials");

    return jwtService.generateToken(user.getEmail());
  }
}
