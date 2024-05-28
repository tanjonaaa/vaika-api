package com.vaika.api.service.security;

import com.vaika.api.model.exception.NotFoundException;
import com.vaika.api.model.security.UserDetailsImpl;
import com.vaika.api.repository.jpa.UserRepository;
import com.vaika.api.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        repository
            .findByEmail(username)
            .orElseThrow(
                () -> new NotFoundException("User with username " + username + " not found"));
    return new UserDetailsImpl(user.getEmail());
  }
}
