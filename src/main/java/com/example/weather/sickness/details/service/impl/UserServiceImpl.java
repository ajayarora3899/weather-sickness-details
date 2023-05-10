package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.dao.User;
import com.example.weather.sickness.details.dao.UserDao;
import com.example.weather.sickness.details.mapper.UserMapper;
import com.example.weather.sickness.details.service.UserService;
import com.example.weather.sickness.details.service.vo.UserRequestVo;
import com.example.weather.sickness.details.service.vo.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserDao dao;

  @Override
  public Mono<UserResponseVo> create(UserRequestVo request) {
    User user = UserMapper.MAPPER.toModel(request);
    Mono<User> savedUser = dao.save(user);
    return savedUser.map(curr -> UserMapper.MAPPER.toVo(curr));
  }

  @Override
  public Mono<UserResponseVo> update(UserRequestVo request) {
    Mono<User> userMono = dao.findById(request.getUsername());
    userMono = userMono.flatMap(user -> {
      user.setCity(request.getCity());
      user.setCountry(request.getCountry());
      return dao.save(user);
    });
    return userMono.map(um -> UserMapper.MAPPER.toVo(um));
  }

  @Override
  public Flux<UserResponseVo> get() {
    Flux<User> users = dao.findAll();
    return users.map(user -> UserMapper.MAPPER.toVo(user)).switchIfEmpty(Flux.empty());
  }

  @Override
  public Mono<UserResponseVo> getById(String username) {
    Mono<User> user = dao.findById(username);
    return user.map((curr) -> UserMapper.MAPPER.toVo(curr));
  }


}
