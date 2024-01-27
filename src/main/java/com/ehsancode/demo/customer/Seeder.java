package com.ehsancode.demo.customer;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Configuration
public class Seeder implements CommandLineRunner {
  private final CustomerRepository customerRepository;

  public Seeder(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    this.customerRepository
        .findCustomerByEmail("ali.ahmadi@gmail.com")
        .ifPresentOrElse(
            System.out::println,
            () -> {
              Customer ali =
                  new Customer("Ali", "Ahmadi", "ali.ahmadi@gmail.com", 22, "09241234567");
              this.customerRepository.save(ali);
            });
    this.customerRepository
        .findCustomerByEmail("ehsan.shavandi@gmail.com")
        .ifPresentOrElse(
            System.out::println,
            () -> {
              Customer ehsan =
                  new Customer("Ehsan", "Shavandi", "ehsan.shavandi@gmail.com", 27, "09251234567");
              this.customerRepository.save(ehsan);
            });

    //    Faker faker = new Faker();
    //    for (int i = 0; i < 10; i++) {
    //      String firstName = faker.name().firstName();
    //      String lastName = faker.name().lastName();
    //      String email = String.format("%s.%s@ehsan.edu", firstName, lastName);
    //      int age = faker.number().numberBetween(15, 45);
    //      String phone = faker.phoneNumber().phoneNumber();
    //      System.out.println(phone);
    //
    //      this.customerRepository
    //          .findCustomerByEmail(email)
    //          .ifPresentOrElse(
    //              System.out::println,
    //              () -> {
    //                Customer customer = new Customer(firstName, lastName, email, age, phone);
    //                this.customerRepository.save(customer);
    //              });
    //    }
  }
}
