package com.example.weather.sickness.details.service.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestVo implements Serializable {

  @NotBlank(message = "username is required")
  private String username;

  @NotBlank(message = "country is required")
  private String country;

  @NotBlank(message = "city is required")
  private String city;

  public UserRequestVo() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
