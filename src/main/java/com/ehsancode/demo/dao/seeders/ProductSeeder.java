package com.ehsancode.demo.dao.seeders;

import com.ehsancode.demo.dao.models.Category;
import com.ehsancode.demo.dao.models.Product;
import com.ehsancode.demo.dao.repositories.CategoryRepository;
import com.ehsancode.demo.dao.repositories.ProductRepository;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSeeder implements CommandLineRunner {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Product> products = this.productRepository.findAll();
    if (!products.isEmpty()) return;
    final Faker faker = new Faker();
    ArrayList<String> cateNames = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String name = faker.programmingLanguage().name();
      Category category = new Category(name);
      if (this.categoryRepository.findByName(name).isEmpty()) {
        this.categoryRepository.save(category);
        cateNames.add(name);
      }
    }

    for (int i = 0; i < 100; i++) {
      String name = faker.app().name();
      String description = faker.lorem().toString();
      int quantity = faker.number().randomDigit();
      int catIndexFromList = faker.number().numberBetween(0, cateNames.size() - 1);
      Optional<Category> categoryOptional =
          this.categoryRepository.findByName(cateNames.get(catIndexFromList));
      if (categoryOptional.isPresent()) {
        Category category = categoryOptional.get();
        Product product = new Product(name, description, quantity, category);
        this.productRepository.save(product);
      }
    }
  }
}
