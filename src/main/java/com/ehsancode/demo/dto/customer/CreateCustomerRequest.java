package com.ehsancode.demo.dto.customer;

import com.ehsancode.demo.exception.appexceptions.NotComplexPasswordException;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateCustomerRequest {
  private static final java.util.regex.Pattern hasLowerCasePattern =
      java.util.regex.Pattern.compile("[a-z]+");
  private static final java.util.regex.Pattern hasUpperCasePattern =
      java.util.regex.Pattern.compile("[A-Z]+");
  private static final java.util.regex.Pattern hasdigitPattern =
      java.util.regex.Pattern.compile("\\d+");
  private static final java.util.regex.Pattern hasSymbolPattern =
      java.util.regex.Pattern.compile("[\\!\\@\\#\\$\\%\\^\\&\\*\\.\\,\\_=]+");

  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @Email private String email;
  @NotBlank private String password;

  @Digits(integer = 100, fraction = 0)
  private Integer age;

  @Pattern(
      regexp = "(?:^[0-9]{11}$)|(?:^(\\d[-\\.])?[0-9]{3}[-\\.][0-9]{3}[-\\.][0-9]{4}$)",
      message = "You need to pass a valid cell phone number")
  private String phone;

  private boolean isVip;

  public CreateCustomerRequest(
      String firstName,
      String lastName,
      String email,
      String password,
      Integer age,
      String phone,
      boolean isVip) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.age = age;
    this.phone = phone;
    this.isVip = isVip;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean isVip() {
    return isVip;
  }

  public void setVip(boolean vip) {
    isVip = vip;
  }
}
