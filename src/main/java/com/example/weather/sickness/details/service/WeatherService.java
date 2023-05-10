package com.example.weather.sickness.details.service;

import com.example.weather.sickness.details.service.vo.WeatherRequestVo;
import com.example.weather.sickness.details.service.vo.WeatherResponseVo;
import reactor.core.publisher.Mono;

public interface WeatherService {

  Mono<WeatherResponseVo> getWeatherDetails(WeatherRequestVo request);
}
