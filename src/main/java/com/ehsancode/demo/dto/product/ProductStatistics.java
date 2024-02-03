package com.ehsancode.demo.dto.product;

public class ProductStatistics {
  private String categoryName;
  private Long totalQuantity;

  public ProductStatistics(String categoryName, Long totalQuantity) {
    this.categoryName = categoryName;
    this.totalQuantity = totalQuantity;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Long getTotalQuantity() {
    return totalQuantity;
  }

  public void setTotalQuantity(Long totalQuantity) {
    this.totalQuantity = totalQuantity;
  }
}
