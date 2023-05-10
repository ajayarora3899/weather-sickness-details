package com.example.weather.sickness.details.mapper;

import com.example.weather.sickness.details.dao.User;
import com.example.weather.sickness.details.service.vo.UserRequestVo;
import com.example.weather.sickness.details.service.vo.UserResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  User toModel(UserRequestVo request);

  UserResponseVo toVo(User user);
}
