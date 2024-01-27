package com.ehsancode.demo.customer;

import com.ehsancode.demo.helper.exception.ApiNotFoundException;
import com.ehsancode.demo.helper.exception.ApiRequestException;

import java.util.List;
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
        .orElseThrow(
            () -> {
              StringBuilder msg = new StringBuilder("Customer ");
              msg.append(id).append(" Not Found");
              return new ApiNotFoundException(msg.toString());
            });
  }

  public void createCustomer(Customer customer) {
    this.customerRepository.save(customer);
  }

  public void deleteCustomerById(int id) {
    this.customerRepository.deleteById(id);
  }
}
