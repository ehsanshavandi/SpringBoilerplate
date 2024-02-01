package com.ehsancode.demo.dto.authentication;

import com.ehsancode.demo.exception.appexceptions.NotComplexPasswordException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.regex.Pattern;

public class RegisterRequest {
  private static final Pattern hasLowerCasePattern = Pattern.compile("[a-z]+");
  private static final Pattern hasUpperCasePattern = Pattern.compile("[A-Z]+");
  private static final Pattern hasdigitPattern = Pattern.compile("\\d+");
  private static final Pattern hasSymbolPattern =
      Pattern.compile("[\\!\\@\\#\\$\\%\\^\\&\\*\\.\\,\\_=]+");

  @NotNull @NotBlank private String firstName;

  @NotNull @NotBlank private String lastName;
  @NotNull @NotBlank @Email private String email;

  @NotNull @NotBlank private String password;

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
    if (!hasLowerCasePattern.matcher(password).find())
      throw new NotComplexPasswordException("Password must be complex");
    if (!hasUpperCasePattern.matcher(password).find())
      throw new NotComplexPasswordException("Password must be complex");
    if (!hasdigitPattern.matcher(password).find())
      throw new NotComplexPasswordException("Password must be complex");
    if (!hasSymbolPattern.matcher(password).find())
      throw new NotComplexPasswordException("Password must be complex");
    this.password = password;
  }
}
