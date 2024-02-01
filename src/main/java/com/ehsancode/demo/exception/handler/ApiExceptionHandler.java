package com.ehsancode.demo.exception.handler;

import com.ehsancode.demo.exception.ApiNotFoundException;
import com.ehsancode.demo.exception.ApiRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

  @ExceptionHandler(value = ApiRequestException.class)
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException) {
    ApiException apiException =
        new ApiException(
            apiRequestException.getMessage(),
            apiRequestException,
            HttpStatus.BAD_REQUEST,
            ZonedDateTime.now());
    return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = ApiNotFoundException.class)
  public ResponseEntity<Object> handleApiNotFoundException(
      ApiNotFoundException apiNotFoundException) {
    ApiException apiException =
        new ApiException(
            apiNotFoundException.getMessage(),
            apiNotFoundException,
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now());
    log.error(apiException.toString());
    return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException methodArgumentNotValidException) {
    Map<String, String> errorMap = new HashMap<>();
    methodArgumentNotValidException
        .getBindingResult()
        .getFieldErrors()
        .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
    ApiException apiException =
        new ApiException(
            "Validation Failed", null, HttpStatus.BAD_REQUEST, ZonedDateTime.now(), errorMap);
    return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
  }
}