package com.vaika.api.service;

import com.vaika.api.endpoint.rest.mapper.UserMapper;
import com.vaika.api.endpoint.rest.model.Credentials;
import com.vaika.api.endpoint.rest.model.CrupdateUser;
import com.vaika.api.model.exception.ForbiddenException;
import com.vaika.api.model.exception.NotFoundException;
import com.vaika.api.repository.jpa.UserRepository;
import com.vaika.api.repository.model.User;
import com.vaika.api.service.security.JwtService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
  private final JwtService jwtService;
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper mapper;

  public String authenticateAndGetToken(Credentials credentials) {
    String email = credentials.getEmail();
    String rawPassword = credentials.getPassword();

    User user =
        repository.findByEmail(email).orElseThrow(() -> new ForbiddenException("Bad credentials"));

    if (!(passwordEncoder.matches(rawPassword, user.getPassword())))
      throw new ForbiddenException("Bad credentials");

    return jwtService.generateToken(user.getEmail());
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User getUserById(String id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("User with identifier " + id + " is not found"));
  }

  public List<User> saveUsers(List<CrupdateUser> toSave) {
    return repository.saveAll(createUsersFrom(toSave));
  }

  public User deleteById(String id) {
    return repository.deleteByIdReturning(id);
  }

  private List<User> createUsersFrom(List<CrupdateUser> crupdateUsers) {
    return crupdateUsers.stream()
        .map(
            user -> {
              user.setPassword(passwordEncoder.encode(user.getPassword()));
              return mapper.toDomain(user);
            })
        .toList();
  }
}
