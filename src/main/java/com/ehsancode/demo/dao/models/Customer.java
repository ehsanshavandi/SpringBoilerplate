package com.ehsancode.demo.dao.models;

import com.ehsancode.demo.dao.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Customer extends User {
  @Id
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
  @Column(updatable = false)
  private Integer id;

  private boolean isVip;
  private Integer age;
  private String phone;

  public Customer() {}

  public Customer(
      String firstName,
      String lastName,
      String email,
      String password,
      Integer age,
      String phone,
      boolean isVip) {
    super(firstName, lastName, email, password, Role.USER);
    this.age = age;
    this.phone = phone;
    this.isVip = isVip;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
