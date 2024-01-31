package com.ehsancode.demo.dao.seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Example implements CommandLineRunner {
  private final Environment environment;

  public Example(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("INJAAAAAAAAAAAc" + " " + this.environment.getProperty("info.app.name"));
  }
}
