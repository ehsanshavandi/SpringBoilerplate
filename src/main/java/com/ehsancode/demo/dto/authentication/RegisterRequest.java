package com.ehsancode.demo.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RegisterRequest {
  @NotNull @NotBlank private String firstName;

  @NotNull @NotBlank private String lastName;
  @NotNull @NotBlank @Email private String email;

  @Pattern(regexp = "(?:[a-z]+[A-Z]+[0-9]+[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\)\\_\\+\\.\\,]){4,8}")
  private String password;

  public RegisterRequest() {}

  public RegisterRequest(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
