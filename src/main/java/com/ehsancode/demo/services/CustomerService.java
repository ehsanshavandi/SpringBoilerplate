package com.ehsancode.demo.services;

import com.ehsancode.demo.dto.customer.CreateCustomerRequest;
import com.ehsancode.demo.exception.appexceptions.AlreadyExistedException;
import com.ehsancode.demo.exception.appexceptions.NotFoundException;

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
        .orElseThrow(() -> new NotFoundException("Customer " + id));
  }

  public void createCustomer(CreateCustomerRequest customerRequest) {
    if (this.customerRepository.findCustomerByEmail(customerRequest.getEmail()).isPresent())
      throw new AlreadyExistedException("Customer " + customerRequest.getEmail());

    final Customer customer =
        new Customer(
            customerRequest.getFirstName(),
            customerRequest.getLastName(),
            customerRequest.getEmail(),
            customerRequest.getAge(),
            customerRequest.getPhone());
    this.customerRepository.save(customer);
  }

  public void deleteCustomerById(int id) {
    this.customerRepository.deleteById(id);
  }
}
