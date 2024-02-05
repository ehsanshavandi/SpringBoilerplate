package com.ehsancode.demo.dao.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Product {
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  private String name;

  private String description;
  private int quantity;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(
      name = "category_id",
      nullable = false,
      referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "category_product_fk"))
  private Category category;

  public Product() {}

  public Product(String name, String description, int quantity, Category category) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Product{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", quantity=").append(quantity);
    sb.append(", createdAt=").append(createdAt);
    sb.append(", category=").append(category);
    sb.append('}');
    return sb.toString();
  }
}
