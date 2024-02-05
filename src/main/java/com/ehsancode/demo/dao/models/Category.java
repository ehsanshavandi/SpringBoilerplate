package com.ehsancode.demo.dao.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, updatable = false)
  private Long categoryId;

  @Column(nullable = false, unique = true)
  private String name;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", updatable = false)
  private LocalDateTime updatedAt;

  public Category() {}

  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Category{");
    sb.append("categoryId=").append(categoryId);
    sb.append(", name='").append(name).append('\'');
    sb.append(", updatedAt=").append(updatedAt);
    sb.append('}');
    return sb.toString();
  }
}
