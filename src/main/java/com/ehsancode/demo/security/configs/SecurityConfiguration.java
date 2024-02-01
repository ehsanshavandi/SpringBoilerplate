package com.ehsancode.demo.security.configs;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.ehsancode.demo.security.Filters.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  public SecurityConfiguration(
      JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
    this.jwtAuthFilter = jwtAuthFilter;
    this.authenticationProvider = authenticationProvider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            req -> req.requestMatchers("/api/v1/auth/**").permitAll().anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
}
