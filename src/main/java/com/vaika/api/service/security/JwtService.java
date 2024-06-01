package com.vaika.api.service.security;

import com.vaika.api.endpoint.rest.security.JwtConf;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JwtService {
  private final JwtConf jwtConf;

  public String generateToken(String email) {
    return Jwts.builder()
        .subject(email)
        .issuedAt(new Date())
        .expiration(new Date((new Date()).getTime() + jwtConf.getExpiration()))
        .signWith(getSigningKey())
        .compact();
  }

  public String validateTokenAndGetUsername(String token) {
    return Jwts.parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
  }

  private SecretKey getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(jwtConf.getSecret());
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
