package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.UserMapper;
import com.vaika.api.endpoint.rest.model.CrupdateUser;
import com.vaika.api.endpoint.rest.model.User;
import com.vaika.api.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserService service;
  private final UserMapper mapper;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return service.getAllUsers().stream().map(mapper::toRest).toList();
  }

  @PutMapping("/users")
  public List<User> saveUsers(@RequestBody List<CrupdateUser> toSave) {
    return service.saveUsers(toSave).stream().map(mapper::toRest).toList();
  }

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable String id) {
    return mapper.toRest(service.getUserById(id));
  }

  @DeleteMapping("/users/{id}")
  public User deleteUserById(@PathVariable String id) {
    return mapper.toRest(service.deleteById(id));
  }
}
