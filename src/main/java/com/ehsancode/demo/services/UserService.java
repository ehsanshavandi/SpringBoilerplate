package com.ehsancode.demo.services;

import com.ehsancode.demo.dao.repositories.UserRepository;
import com.ehsancode.demo.exception.ApiNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDetails getUserByEmail(String email) {
    return this.userRepository
        .findUserByEmail(email)
        .orElseThrow(() -> new ApiNotFoundException("User " + email + " Not Found"));
  }
}
