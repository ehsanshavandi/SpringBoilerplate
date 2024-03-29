package com.ehsancode.demo.controllers;

import com.ehsancode.demo.dao.models.Customer;
import com.ehsancode.demo.dao.models.Order;
import com.ehsancode.demo.dto.ResponsePagable;
import com.ehsancode.demo.dto.customer.CreateCustomerRequest;
import com.ehsancode.demo.dto.customer.UpdateCustomerRequest;
import com.ehsancode.demo.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PutMapping(path = "{id}")
  public ResponseEntity<Customer> modifyCustomer(
      @Valid @PathVariable int customerId, @Valid @RequestBody UpdateCustomerRequest request) {
    Customer updatedCustomer = this.customerService.updateCustomer(customerId, request);
    return ResponseEntity.ok().body(updatedCustomer);
  }

  @DeleteMapping(path = "{id}")
  public void removeCustomer(@Valid @PathVariable("id") int id) {
    this.customerService.deleteCustomerById(id);
  }

  //
  @GetMapping(path = "/orders/{id}")
  public ResponseEntity<List<Order>> getAllOrdersByCustomer(@Valid @PathVariable("id") int id) {
    List<Order> orders = this.customerService.findAllOrdersByCustomer(id);
    return ResponseEntity.ok().body(orders);
  }
}
