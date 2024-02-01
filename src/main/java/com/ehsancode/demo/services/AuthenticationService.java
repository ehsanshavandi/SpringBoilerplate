package com.ehsancode.demo.services;

import com.ehsancode.demo.dao.models.User;
import com.ehsancode.demo.dao.models.enums.Role;
import com.ehsancode.demo.dao.repositories.UserRepository;
import com.ehsancode.demo.dto.authentication.LoginRequest;
import com.ehsancode.demo.dto.authentication.LoginResponse;
import com.ehsancode.demo.dto.authentication.RegisterRequest;
import com.ehsancode.demo.exception.appexceptions.AlreadyExistedException;
import com.ehsancode.demo.security.services.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public LoginResponse register(RegisterRequest registerRequest) {
    if (this.userRepository.findUserByEmail(registerRequest.getEmail()).isPresent())
      throw new AlreadyExistedException("User " + registerRequest.getEmail());
    User user =
        new User(
            registerRequest.getFirstName(),
            registerRequest.getLastName(),
            registerRequest.getEmail(),
            this.passwordEncoder.encode(registerRequest.getPassword()),
            Role.USER);
    this.userRepository.save(user);
    String token = this.jwtService.generateToken(user);
    return new LoginResponse(token);
  }

  public LoginResponse login(LoginRequest loginRequest) {
    this.authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getEmail(), loginRequest.getPassword()));
    var user = this.userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow();
    String token = this.jwtService.generateToken(user);
    return new LoginResponse(token);
  }
}
