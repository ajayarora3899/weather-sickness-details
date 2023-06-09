package com.example.weather.sickness.details.controller;

import com.example.weather.sickness.details.service.WeatherService;
import com.example.weather.sickness.details.service.vo.WeatherRequestVo;
import com.example.weather.sickness.details.service.vo.WeatherResponseVo;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

  @Autowired
  private WeatherService service;

  @PostMapping
  public Mono<ResponseEntity<WeatherResponseVo>> getWeatherDetails(
      @Valid @RequestBody WeatherRequestVo request) {
    Mono<WeatherResponseVo> response = service.getWeatherDetails(request);
    return response.map(weather -> ResponseEntity.ok().body(weather));
  }

}
