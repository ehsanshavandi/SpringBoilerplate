package com.ehsancode.demo.dto.customer;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateCustomerRequest {

  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @Email private String email;

  @Digits(integer = 100, fraction = 0)
  private Integer age;

  @Pattern(
      regexp = "(?:^[0-9]{11}$)|(?:^(\\d[-\\.])?[0-9]{3}[-\\.][0-9]{3}[-\\.][0-9]{4}$)",
      message = "You need to pass a valid cell phone number")
  private String phone;

  public CreateCustomerRequest(
      String firstName, String lastName, String email, Integer age, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.phone = phone;
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
}
