package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.service.WeatherService;
import com.example.weather.sickness.details.service.vo.WeatherRequestVo;
import com.example.weather.sickness.details.service.vo.WeatherResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService {

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<WeatherResponseVo> getWeatherDetails(WeatherRequestVo request) {

    String url = UriComponentsBuilder.fromHttpUrl("https://api.open-meteo.com/v1/forecast")
        .queryParam("latitude", request.getLatitude())
        .queryParam("longitude", request.getLongitude())
        .queryParam("current_weather", true)
        .buildAndExpand().toString();

    return webClient.get().uri(url).retrieve().bodyToMono(WeatherResponseVo.class).log();
  }
}
