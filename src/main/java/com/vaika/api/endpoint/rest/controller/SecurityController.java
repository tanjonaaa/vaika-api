package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.model.Credentials;
import com.vaika.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController {
  private final UserService service;

  @PostMapping("/login")
  public String authenticateAndGetToken(Credentials credentials) {
    return service.authenticateAndGetToken(credentials);
  }
}
