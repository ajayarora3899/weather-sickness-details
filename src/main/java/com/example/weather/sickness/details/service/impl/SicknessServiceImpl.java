package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.service.SicknessService;
import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
import javax.security.sasl.SaslServer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SicknessServiceImpl implements SicknessService {

  @Override
  public Mono<SicknessResponseVo> getSicknessDetails(SicknessRequestVo request) {

    return null;
  }
}
