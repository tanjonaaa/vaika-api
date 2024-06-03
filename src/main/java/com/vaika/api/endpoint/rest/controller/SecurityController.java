package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.UserMapper;
import com.vaika.api.endpoint.rest.model.Credentials;
import com.vaika.api.endpoint.rest.model.LoginResponse;
import com.vaika.api.endpoint.rest.model.Whoami;
import com.vaika.api.endpoint.rest.security.model.Principal;
import com.vaika.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController {
  private final UserService userService;
  private final UserMapper userMapper;

  @PostMapping("/login")
  public LoginResponse authenticateAndGetToken(@RequestBody Credentials credentials) {
    return new LoginResponse().token(userService.authenticateAndGetToken(credentials));
  }

  @GetMapping("/whoami")
  public Whoami whoami(@AuthenticationPrincipal Principal principal) {
    return new Whoami().user(userMapper.toRest(principal.getUser())).bearer(principal.getBearer());
  }
}
