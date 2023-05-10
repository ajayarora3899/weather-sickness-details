package com.example.weather.sickness.details.service.vo;

import java.util.Map;

public class WeatherResponseVo {
  private Double latitude;
  private Double longitude;
  private Double generationtime_ms;
  private Integer utc_offset_seconds;
  private String timezone;
  private String timezone_abbreviation;
  private Double elevation;
  private Map<String, Object> current_weather;

  public WeatherResponseVo() {
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

  public Double getGenerationtime_ms() {
    return generationtime_ms;
  }

  public void setGenerationtime_ms(Double generationtime_ms) {
    this.generationtime_ms = generationtime_ms;
  }

  public Integer getUtc_offset_seconds() {
    return utc_offset_seconds;
  }

  public void setUtc_offset_seconds(Integer utc_offset_seconds) {
    this.utc_offset_seconds = utc_offset_seconds;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getTimezone_abbreviation() {
    return timezone_abbreviation;
  }

  public void setTimezone_abbreviation(String timezone_abbreviation) {
    this.timezone_abbreviation = timezone_abbreviation;
  }

  public Double getElevation() {
    return elevation;
  }

  public void setElevation(Double elevation) {
    this.elevation = elevation;
  }

  public Map<String, Object> getCurrent_weather() {
    return current_weather;
  }

  public void setCurrent_weather(Map<String, Object> current_weather) {
    this.current_weather = current_weather;
  }
}
