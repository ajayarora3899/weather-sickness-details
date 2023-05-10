package com.example.weather.sickness.details.service;

import com.example.weather.sickness.details.service.vo.UserRequestVo;
import com.example.weather.sickness.details.service.vo.UserResponseVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<UserResponseVo> create(UserRequestVo request);

  Mono<UserResponseVo> update(UserRequestVo request);

  Flux<UserResponseVo> get();

  Mono<UserResponseVo> getById(String username);
}
