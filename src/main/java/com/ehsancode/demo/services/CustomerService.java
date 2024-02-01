package com.ehsancode.demo.services;

import com.ehsancode.demo.exception.ApiNotFoundException;

import java.util.List;

import com.ehsancode.demo.dao.models.Customer;
import com.ehsancode.demo.dao.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> selectAllCustomers() {
    return this.customerRepository.findAll();
  }

  public Customer selectCustomerById(int id) {
    return this.customerRepository
        .findById(id)
        .orElseThrow(() -> new ApiNotFoundException("Customer " + id + " Not Found"));
  }

  public void createCustomer(Customer customer) {
    this.customerRepository.save(customer);
  }

  public void deleteCustomerById(int id) {
    this.customerRepository.deleteById(id);
  }
}
