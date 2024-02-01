package com.ehsancode.demo.exception.appexceptions;

import org.springframework.http.HttpStatus;

public class NotComplexPasswordException extends AppException {
  private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

  public NotComplexPasswordException(String message) {
    super(message, httpStatus);
  }
}
