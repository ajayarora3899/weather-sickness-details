package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.service.WeatherService;
import com.example.weather.sickness.details.service.exception.WellnessWidgetException;
import com.example.weather.sickness.details.service.vo.WeatherRequestVo;
import com.example.weather.sickness.details.service.vo.WeatherResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    return webClient.get()
        .uri(url)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
          if (clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
            return Mono.error(
                new WellnessWidgetException(HttpStatus.NOT_FOUND.value(), "Data not found"));
          }
          return clientResponse.bodyToMono(String.class).flatMap(responseMessage -> Mono.error(
              new WellnessWidgetException(clientResponse.statusCode().value(), responseMessage)));
        })
        .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
          if (clientResponse.statusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            return Mono.error(
                new WellnessWidgetException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Some internal server error - external api"));
          }
          return clientResponse.bodyToMono(String.class).flatMap(responseMessage -> Mono.error(
              new WellnessWidgetException(clientResponse.statusCode().value(), responseMessage)));
        })
        .onStatus(HttpStatus::isError, clientResponse -> {
          return clientResponse.bodyToMono(String.class).flatMap(responseMessage -> Mono.error(
              new WellnessWidgetException(clientResponse.statusCode().value(), responseMessage)));
        })
        .bodyToMono(WeatherResponseVo.class);
  }
}
