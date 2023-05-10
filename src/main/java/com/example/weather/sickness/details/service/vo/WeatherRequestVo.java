package com.example.weather.sickness.details.service.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WeatherRequestVo {

  @NotNull(message = "latitude is required")
  private Double latitude;

  @NotNull(message = "longitude is required")
  private Double longitude;

  public WeatherRequestVo() {
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }
}
