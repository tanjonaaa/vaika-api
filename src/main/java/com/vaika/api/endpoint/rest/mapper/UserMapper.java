package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.CrupdateUser;
import com.vaika.api.endpoint.rest.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toRest(com.vaika.api.repository.model.User user) {
    return new User().id(user.getId()).email(user.getEmail()).username(user.getUsername());
  }

  public com.vaika.api.repository.model.User toDomain(CrupdateUser user) {
    return com.vaika.api.repository.model.User.builder()
        .id(user.getId())
        .email(user.getEmail())
        .username(user.getUsername())
        .password(user.getPassword())
        .build();
  }
}
