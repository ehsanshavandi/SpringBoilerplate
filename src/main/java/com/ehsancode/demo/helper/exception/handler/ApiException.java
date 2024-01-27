package com.ehsancode.demo.helper.exception.handler;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Map;

public class ApiException {
  private final String message;
  private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final ZonedDateTime zonedDateTime;
  private Map<String, String> errorValidationMap = null;

  public String getMessage() {
    return message;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ZonedDateTime getZonedDateTime() {
    return zonedDateTime;
  }

  public Map<String, String> getErrorValidationMap() {
    return errorValidationMap;
  }

  public ApiException(
      String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
    this.message = message;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.zonedDateTime = zonedDateTime;
  }

  public ApiException(
      String message,
      Throwable throwable,
      HttpStatus httpStatus,
      ZonedDateTime zonedDateTime,
      Map<String, String> errorValidationMap) {
    this.message = message;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.zonedDateTime = zonedDateTime;
    this.errorValidationMap = errorValidationMap;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ApiException{");
    sb.append("message='").append(message).append('\'');
    sb.append(", throwable=").append(throwable);
    sb.append(", httpStatus=").append(httpStatus);
    sb.append(", zonedDateTime=").append(zonedDateTime);
    sb.append(", errorValidationMap=").append(errorValidationMap);
    sb.append('}');
    return sb.toString();
  }
}
