package com.example.weather.sickness.details.service.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

@ControllerAdvice
public class GlobalErrorHandler {

  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<ExceptionResponse> handleValidationExceptions(WebExchangeBindException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    ExceptionResponse response = new ExceptionResponse(errors, HttpStatus.BAD_REQUEST.value(), "validation failed");
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(WellnessWidgetException.class)
  public ResponseEntity<ExceptionResponse> serverExceptionHandler(WellnessWidgetException ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode(ex.getErrorCode());
    response.setMessage(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> serverExceptionHandler(Exception ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.setMessage(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
