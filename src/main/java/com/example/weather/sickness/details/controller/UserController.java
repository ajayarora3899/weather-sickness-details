package com.example.weather.sickness.details.controller;

import com.example.weather.sickness.details.service.UserService;
import com.example.weather.sickness.details.service.enums.ErrorCodes;
import com.example.weather.sickness.details.service.exception.WellnessWidgetException;
import com.example.weather.sickness.details.service.vo.UserRequestVo;
import com.example.weather.sickness.details.service.vo.UserResponseVo;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public Mono<ResponseEntity<UserResponseVo>> create(@Valid @RequestBody UserRequestVo request) {
    Mono<UserResponseVo> response = service.create(request);
    return response.map(user -> ResponseEntity.ok().body(user));
  }

  @PutMapping
  public Mono<ResponseEntity<UserResponseVo>> update(@Valid @RequestBody UserRequestVo request) {
    Mono<UserResponseVo> response = service.update(request);
    return response.map(user -> ResponseEntity.ok().body(user));
  }

  @GetMapping
  public Flux<UserResponseVo> get() {
    Flux<UserResponseVo> response = service.get();
    return response;
  }

  @GetMapping("/{username}")
  public Mono<ResponseEntity<UserResponseVo>> getById(@PathVariable("username") String username) {
    Mono<UserResponseVo> response = service.getById(username);
    return response.map(user -> ResponseEntity.ok().body(user));
  }

}
