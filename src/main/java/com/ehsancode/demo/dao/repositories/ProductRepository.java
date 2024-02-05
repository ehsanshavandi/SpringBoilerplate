package com.ehsancode.demo.dao.repositories;

import com.ehsancode.demo.dao.models.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "SELECT * FROM product WHERE category_id = :categoryId", nativeQuery = true)
  List<Product> findByCategoryId(Long categoryId);

  @Query(
      value =
          "SELECT c.name, SUM(p.quantity) FROM product p INNER JOIN category c ON p.category_id = c.id GROUP BY c.name",
      nativeQuery = true)
  List<Object[]> findTotalQuantityByCategory();
}
