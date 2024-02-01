package com.ehsancode.demo.exception.appexceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistedException extends AppException {
  private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

  public AlreadyExistedException(String message) {
    super(message + " has Already existed", httpStatus);
  }
}
