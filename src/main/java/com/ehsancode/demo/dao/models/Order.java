package com.ehsancode.demo.dao.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "_order")
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", updatable = false)
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(
      name = "customer_id",
      nullable = false,
      referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "customer_order_fk"))
  private Customer customer;

  @OneToOne
  @JoinColumn(
      name = "product_id",
      nullable = false,
      referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "product_order_fk"))
  private Product product;

  public Order() {}

  public Order(Customer customer, Product product) {
    this.customer = customer;
    this.product = product;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Order{");
    sb.append("id=").append(id);
    sb.append(", createdAt=").append(createdAt);
    sb.append(", updatedAt=").append(updatedAt);
    sb.append(", customer=").append(customer);
    sb.append(", product=").append(product);
    sb.append('}');
    return sb.toString();
  }
}
