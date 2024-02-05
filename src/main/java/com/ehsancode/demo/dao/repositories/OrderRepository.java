package com.ehsancode.demo.dao.repositories;

import com.ehsancode.demo.dao.models.Customer;
import com.ehsancode.demo.dao.models.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findAllByCustomer(Customer customer);

  //  @Query()
  //  List<Product> findProductsByCustomer(Customer customer);
}
