package com.ehsancode.demo.dao.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
  @Id
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
  @Column(updatable = false)
  private Integer id;

  private String firstName;
  private String lastName;

  @Column(nullable = false, unique = true)
  @Email
  private String email;

  private Integer age;
  private String phone;

  public Customer() {}

  public Customer(String firstName, String lastName, String email, Integer age, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Customer{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", age=").append(age);
    sb.append(", phone='").append(phone).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
