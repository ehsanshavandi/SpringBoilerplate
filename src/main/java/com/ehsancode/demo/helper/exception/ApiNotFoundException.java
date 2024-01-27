package com.ehsancode.demo.helper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiNotFoundException extends RuntimeException {
  private int errorCode;
  private String errorMessage;

  public ApiNotFoundException(Throwable throwable) {
    super(throwable);
  }

  public ApiNotFoundException(String msg, Throwable throwable) {
    super(msg, throwable);
  }

  public ApiNotFoundException(String msg) {
    super(msg);
  }

  public ApiNotFoundException(String message, int errorCode) {
    super();
    this.errorCode = errorCode;
    this.errorMessage = message;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  @Override
  public String toString() {
    return this.errorCode + " : " + this.getErrorMessage();
  }
}
