package com.example.weather.sickness.details.service;

import com.example.weather.sickness.details.service.exception.WellnessWidgetException;
import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import reactor.core.publisher.Mono;

public interface SicknessService {

  Mono<SicknessResponseVo> getSicknessDetails(SicknessRequestVo request)
      throws WellnessWidgetException, ExecutionException, InterruptedException, TimeoutException;
}
