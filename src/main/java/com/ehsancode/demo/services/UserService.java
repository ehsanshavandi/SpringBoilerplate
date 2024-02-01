package com.ehsancode.demo.services;

import com.ehsancode.demo.dao.repositories.UserRepository;
import com.ehsancode.demo.exception.appexceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
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
        .orElseThrow(() -> new NotFoundException("User " + email));
  }
}
