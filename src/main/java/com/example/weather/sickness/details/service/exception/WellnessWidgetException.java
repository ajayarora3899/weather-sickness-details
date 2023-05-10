package com.example.weather.sickness.details.service.exception;

public class WellnessWidgetException extends Exception{

  private Integer errorCode;

  public WellnessWidgetException() {
    super();
  }

  public WellnessWidgetException(String message) {
    super(message);
  }

  public WellnessWidgetException(Integer errorCode, String message) {
    super(message);
    this.errorCode=errorCode;
  }

  public WellnessWidgetException(String message, Throwable cause) {
    super(message, cause);
  }

  public WellnessWidgetException(Throwable cause) {
    super(cause);
  }

  protected WellnessWidgetException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }
}
