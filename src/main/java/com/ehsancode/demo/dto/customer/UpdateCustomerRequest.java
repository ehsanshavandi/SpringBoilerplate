package com.ehsancode.demo.dto.customer;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

public class UpdateCustomerRequest {

  private String firstName;
  private String lastName;
  private Integer age;

  public UpdateCustomerRequest() {}

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }
}
