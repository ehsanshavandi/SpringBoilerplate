package com.ehsancode.demo.services;

import com.ehsancode.demo.dao.models.Customer;
import com.ehsancode.demo.dao.repositories.CustomerRepository;
import com.ehsancode.demo.dto.ResponsePagable;
import com.ehsancode.demo.dto.customer.CreateCustomerRequest;
import com.ehsancode.demo.dto.customer.UpdateCustomerRequest;
import com.ehsancode.demo.exception.appexceptions.AlreadyExistedException;
import com.ehsancode.demo.exception.appexceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public ResponsePagable<Customer> selectAllCustomers(int page, int size) {
    final PageRequest pageRequest = PageRequest.of(page, size);
    final Page<Customer> pageCustomer = this.customerRepository.findAll(pageRequest);
    return new ResponsePagable<>(
        pageCustomer.getTotalElements(),
        pageCustomer.getTotalPages(),
        pageCustomer.hasNext(),
        pageCustomer.toList());
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

  public Customer updateCustomer(int customerId, UpdateCustomerRequest request) {
    Customer customer =
        this.customerRepository
            .findById(customerId)
            .orElseThrow(() -> new NotFoundException("Customer " + customerId));
    if (request.getFirstName() != null) customer.setFirstName(request.getFirstName());
    if (request.getLastName() != null) customer.setLastName(request.getLastName());
    if (request.getAge() != null) customer.setAge(request.getAge());
    return this.customerRepository.save(customer);
  }

  public void deleteCustomerById(int id) {
    this.customerRepository.deleteById(id);
  }
}
