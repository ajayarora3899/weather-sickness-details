package com.example.weather.sickness.details.service.enums;

public enum ErrorCodes {

  USER_NOT_FOUND(1111,"User not found!!!"),
  NOT_FOUND(1112, "Not Found!!!");

  private Integer errorCode;
  private String message;

  ErrorCodes(Integer errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public String getMessage() {
    return message;
  }
}
