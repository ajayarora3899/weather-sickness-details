package com.example.weather.sickness.details.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserDao extends ReactiveCrudRepository<User, String> {

}
