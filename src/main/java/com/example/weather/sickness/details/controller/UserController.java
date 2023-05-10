package com.example.weather.sickness.details.controller;

import com.example.weather.sickness.details.service.UserService;
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

  @Autowired private UserService service;

  @PostMapping
  public ResponseEntity<Mono<UserResponseVo>> create(@Valid @RequestBody UserRequestVo request) {
    Mono<UserResponseVo> response = service.create(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Mono<UserResponseVo>> update(@Valid @RequestBody UserRequestVo request) {
    Mono<UserResponseVo> response = service.update(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Flux<UserResponseVo>> get() {
    Flux<UserResponseVo> response = service.get().log();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{username}")
  public ResponseEntity<Mono<UserResponseVo>> getById(@PathVariable("username") String username) {
    Mono<UserResponseVo> response = service.getById(username).log();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
