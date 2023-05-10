package com.example.weather.sickness.details.service;

import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
import reactor.core.publisher.Mono;

public interface SicknessService {

  Mono<SicknessResponseVo> getSicknessDetails(SicknessRequestVo request);
}
