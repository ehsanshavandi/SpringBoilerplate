package com.ehsancode.demo.exception.appexceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException {
  private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

  public NotFoundException(String message) {
    super(message + " Not Found", httpStatus);
  }
}
