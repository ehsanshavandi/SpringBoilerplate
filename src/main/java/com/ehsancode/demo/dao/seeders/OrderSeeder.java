package com.ehsancode.demo.dao.seeders;

import com.ehsancode.demo.dao.models.Order;
import com.ehsancode.demo.dao.models.Product;
import com.ehsancode.demo.dao.repositories.CustomerRepository;
import com.ehsancode.demo.dao.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderSeeder implements CommandLineRunner {
  private final OrderRepository orderRepository;
  private final CustomerRepository customerRepository;

  public OrderSeeder(OrderRepository orderRepository, CustomerRepository customerRepository) {
    this.orderRepository = orderRepository;
    this.customerRepository = customerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    //    List<Order> orders =
    //        this.orderRepository.findAllByCustomer(
    //
    // this.customerRepository.findCustomerByEmail("ehsan.shavandi@gmail.com").orElseThrow());
    //    System.out.println("****************" + orders);
    //    List<Product> products =
    //        this.orderRepository.findProductsByCustomer(
    //
    // this.customerRepository.findCustomerByEmail("ehsan.shavandi@gmail.com").orElseThrow());
    //    System.out.println("****************" + products);
  }
}
