package com.ehsancode.demo.controllers;

import com.ehsancode.demo.dto.authentication.LoginRequest;
import com.ehsancode.demo.dto.authentication.LoginResponse;
import com.ehsancode.demo.dto.authentication.RegisterRequest;
import com.ehsancode.demo.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/register")
  public ResponseEntity<LoginResponse> register(
      @Valid @RequestBody RegisterRequest registerRequest) {
    return ResponseEntity.ok(this.authenticationService.register(registerRequest));
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(this.authenticationService.login(loginRequest));
  }
}
