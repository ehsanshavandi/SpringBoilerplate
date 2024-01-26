package com.ehsancode.demo.customer;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/customers")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping()
  public List<Customer> getCustomers() {
    return this.customerService.selectAllCustomers();
  }

  @GetMapping(path = "{id}")
  public Customer getCustomer(@PathVariable("id") int id) {
    return this.customerService.selectCustomerById(id);
  }

  @PostMapping()
  public void addCustomer(@RequestBody Customer customer) {
    this.customerService.createCustomer(customer);
  }

  @PutMapping()
  public void modifyCustomer(@RequestBody Customer customer) {
    //    this.customerService.createCustomer(customer);
  }

  @DeleteMapping(path = "{id}")
  public void removeCustomer(@PathVariable("id") int id) {
    this.customerService.deleteCustomerById(id);
  }
}
