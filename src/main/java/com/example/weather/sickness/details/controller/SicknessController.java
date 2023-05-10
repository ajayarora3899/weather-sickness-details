package com.example.weather.sickness.details.controller;

import com.example.weather.sickness.details.service.SicknessService;
import com.example.weather.sickness.details.service.WeatherService;
import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
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
@RequestMapping("/v1/sickness")
public class SicknessController {

  @Autowired
  private SicknessService service;

  @PostMapping
  public ResponseEntity<Mono<SicknessResponseVo>> getSicknessDetails(
      @Valid @RequestBody SicknessRequestVo request) {
    Mono<SicknessResponseVo> response = service.getSicknessDetails(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
  
}
