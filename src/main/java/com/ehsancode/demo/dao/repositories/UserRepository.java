package com.ehsancode.demo.dao.repositories;

import com.ehsancode.demo.dao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  public Optional<UserDetails> findUserByEmail(String email);
}
