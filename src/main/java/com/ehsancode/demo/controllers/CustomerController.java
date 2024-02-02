package com.ehsancode.demo.controllers;

import java.util.List;

import com.ehsancode.demo.dto.ResponsePagable;
import com.ehsancode.demo.dto.customer.CreateCustomerRequest;
import com.ehsancode.demo.services.CustomerService;
import com.ehsancode.demo.dao.models.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/customers")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping()
  public ResponseEntity<ResponsePagable<Customer>> getCustomers(
      @Valid @RequestParam(defaultValue = "0") int page,
      @Valid @RequestParam(defaultValue = "10") int size) {
    ResponsePagable<Customer> customers = this.customerService.selectAllCustomers(page, size);
    return ResponseEntity.ok().body(customers);
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<Customer> getCustomer(@Valid @PathVariable("id") int id) {
    Customer customer = this.customerService.selectCustomerById(id);
    return ResponseEntity.ok().body(customer);
  }

  @PostMapping()
  public void addCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
    this.customerService.createCustomer(createCustomerRequest);
  }

  @PutMapping()
  public void modifyCustomer(@Valid @RequestBody Customer customer) {
    //    this.customerService.createCustomer(customer);
  }

  @DeleteMapping(path = "{id}")
  public void removeCustomer(@Valid @PathVariable("id") int id) {
    this.customerService.deleteCustomerById(id);
  }
}
