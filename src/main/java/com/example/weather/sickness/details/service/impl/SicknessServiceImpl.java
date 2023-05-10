package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.dao.User;
import com.example.weather.sickness.details.dao.UserDao;
import com.example.weather.sickness.details.service.SicknessService;
import com.example.weather.sickness.details.service.exception.WellnessWidgetException;
import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.security.sasl.SaslServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class SicknessServiceImpl implements SicknessService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<SicknessResponseVo> getSicknessDetails(SicknessRequestVo request)
      throws WellnessWidgetException, ExecutionException, InterruptedException, TimeoutException {
    String country = request.getCountry();

    if (Objects.isNull(country)) {
      Mono<User> user = userDao.findById(request.getUsername());
      User user1 = user.subscribeOn(Schedulers.boundedElastic()).toFuture()
          .get(5L, TimeUnit.SECONDS);
      if (Objects.nonNull(user1)) {
        country = user1.getCountry();
      }
    }

    if (Objects.isNull(country)) {
      throw new WellnessWidgetException(1112, "Country is required");
    }

    return webClient.get()
        .uri("https://corona.lmao.ninja/v2/countries/{country}", country)
        .retrieve()
        .bodyToMono(SicknessResponseVo.class);
  }
}
