package com.vaika.api.endpoint.rest.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class JwtConf {
  private final String secret;
  private final long expiration;

  public JwtConf(
      @Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expiration) {
    this.secret = secret;
    this.expiration = expiration;
  }
}
