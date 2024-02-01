package com.ehsancode.demo.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  @Value("${info.security.jwt.secret_key}")
  private String SECRET_KEY;

  @Value("${info.security.jwt.expire_token}")
  private long EXPIRE_MILLI_SECOND;

  public JwtService() {}

  public Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(this.getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = this.extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String extractUserEmailFromToken(String token) {
    return this.extractClaim(token, Claims::getSubject);
  }

  public String generateToken(UserDetails userDetails) {
    return this.generateToken(new HashMap<>(), userDetails);
  }

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MILLI_SECOND))
        .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String userEmail = this.extractUserEmailFromToken(token);
    return userEmail.equals(userDetails.getUsername()) && !this.isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return this.extractExpirationDate(token).before(new Date());
  }

  private Date extractExpirationDate(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
}
