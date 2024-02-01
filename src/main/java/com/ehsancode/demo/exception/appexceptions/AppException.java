package com.ehsancode.demo.exception.appexceptions;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
  private HttpStatus httpStatus;

  public AppException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public AppException(Throwable throwable) {
    super(throwable);
  }

  public AppException(String msg, Throwable throwable) {
    super(msg, throwable);
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AppException{");
    sb.append("Message is=").append(this.getMessage());
    sb.append("httpStatus=").append(httpStatus);
    sb.append('}');
    return sb.toString();
  }
}
