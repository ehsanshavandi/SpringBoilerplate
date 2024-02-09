package com.ehsancode.demo.dao.seeders;

import com.ehsancode.demo.dao.models.Customer;
import com.ehsancode.demo.dao.repositories.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomerSeeder implements CommandLineRunner {
  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public CustomerSeeder(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {

    this.customerRepository
        .findCustomerByEmail("ali.ahmadi@gmail.com")
        .ifPresentOrElse(
            System.out::println,
            () -> {
              Customer ali =
                  new Customer(
                      "Ali",
                      "Ahmadi",
                      "ali.ahmadi@gmail.com",
                      this.passwordEncoder.encode("aA@123"),
                      22,
                      "09241234567",
                      false);
              this.customerRepository.save(ali);
            });
    this.customerRepository
        .findCustomerByEmail("ehsan.shavandi@gmail.com")
        .ifPresentOrElse(
            System.out::println,
            () -> {
              Customer ehsan =
                  new Customer(
                      "Ehsan",
                      "Shavandi",
                      "ehsan.shavandi@gmail.com",
                      this.passwordEncoder.encode("P@ssW0rd"),
                      27,
                      "09251234567",
                      true);
              this.customerRepository.save(ehsan);
            });
    //
    //    Faker faker = new Faker();
    //    for (int i = 0; i < 100; i++) {
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
