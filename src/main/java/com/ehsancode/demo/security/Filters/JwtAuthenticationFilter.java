package com.ehsancode.demo.security.Filters;

import com.ehsancode.demo.security.services.JwtService;
import com.ehsancode.demo.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private static final int indexOfStartingToke = "Bearer ".length();
  private final JwtService jwtService;
  private final UserService userService;

  public JwtAuthenticationFilter(JwtService jwtService, UserService userService) {
    this.jwtService = jwtService;
    this.userService = userService;
  }

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    final String jwt = authHeader.substring(indexOfStartingToke);
    final String userEmail = this.jwtService.extractUserEmailFromToken(jwt);

    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      // Email exists on Token and not being authenticated
      // We need to fetch userDetails from DB
      UserDetails userDetails = this.userService.getUserByEmail(userEmail);
      // User fetched and time to check validity
      if (this.jwtService.isTokenValid(jwt, userDetails)) {
        // Update Dispatcher
        UsernamePasswordAuthenticationToken authToken =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // Update security context holder
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
      filterChain.doFilter(request, response);
    }
  }
}
