package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toRest(com.vaika.api.repository.model.User user) {
    return new User().id(user.getId()).email(user.getEmail()).username(user.getUsername());
  }
}
