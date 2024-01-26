package com.ehsancode.demo;

import java.lang.reflect.Method;
import java.util.List;

import com.ehsancode.demo.customer.Customer;
import com.ehsancode.demo.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @GetMapping("/")
  public String helloWorld() {
    Class<? extends DemoApplication> c = this.getClass();
    Method[] methods = c.getDeclaredMethods();
    StringBuilder result = new StringBuilder();
    for (Method m : methods) {
      result.append(m.toString());
      result.append("\n");
    }
    return result.toString();
  }
}
