package com.ehsancode.demo.dto;

import java.util.List;

public class ResponsePagable<T> {

  private long totalElements;
  private int totalPages;
  private boolean hasNextPage;
  private List<T> data;

  public ResponsePagable(long totalElements, int totalPages, boolean hasNextPage, List<T> data) {
    this.totalElements = totalElements;
    this.totalPages = totalPages;
    this.hasNextPage = hasNextPage;
    this.data = data;
  }

  public long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }

  public boolean isHasNextPage() {
    return hasNextPage;
  }

  public void setHasNextPage(boolean hasNextPage) {
    this.hasNextPage = hasNextPage;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
