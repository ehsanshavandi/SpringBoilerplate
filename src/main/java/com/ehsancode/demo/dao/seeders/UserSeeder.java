package com.ehsancode.demo.dao.seeders;

import com.ehsancode.demo.dao.models.User;
import com.ehsancode.demo.dao.models.enums.Role;
import com.ehsancode.demo.dao.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSeeder implements CommandLineRunner {
  private final Environment environment;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserSeeder(
      Environment environment, UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.environment = environment;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {
    String firstName = this.environment.getProperty("info.seeder.superadmin.first_name");
    String lastName = this.environment.getProperty("info.seeder.superadmin.last_name");
    String email = this.environment.getProperty("info.seeder.superadmin.email");
    String password = this.environment.getProperty("info.seeder.superadmin.password");
    String role = this.environment.getProperty("info.seeder.superadmin.role");
    // check superadmin existed or not
    if (this.userRepository.findUserByEmail(email).isPresent()) return;
    User superAdmin =
        new User(
            firstName, lastName, email, this.passwordEncoder.encode(password), Role.valueOf(role));
    this.userRepository.save(superAdmin);
  }
}
