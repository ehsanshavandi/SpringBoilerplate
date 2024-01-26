package com.ehsancode.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  Optional<Customer> findCustomerByEmail(String email);

  List<Customer> findCustomersByFirstName(String firstName);
}
