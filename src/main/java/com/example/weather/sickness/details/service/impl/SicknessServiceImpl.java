package com.example.weather.sickness.details.service.impl;

import com.example.weather.sickness.details.dao.User;
import com.example.weather.sickness.details.dao.UserDao;
import com.example.weather.sickness.details.service.SicknessService;
import com.example.weather.sickness.details.service.enums.ErrorCodes;
import com.example.weather.sickness.details.service.exception.WellnessWidgetException;
import com.example.weather.sickness.details.service.vo.SicknessRequestVo;
import com.example.weather.sickness.details.service.vo.SicknessResponseVo;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.security.sasl.SaslServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class SicknessServiceImpl implements SicknessService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<SicknessResponseVo> getSicknessDetails(SicknessRequestVo request)
      throws ExecutionException, InterruptedException, TimeoutException {
    String country = request.getCountry();

    if (Objects.isNull(country)) {
      Mono<User> user = userDao.findById(request.getUsername())
          .switchIfEmpty(Mono.error(
              new WellnessWidgetException(ErrorCodes.USER_NOT_FOUND.getErrorCode(),
                  ErrorCodes.USER_NOT_FOUND.getMessage())));

      User user1 = user.subscribeOn(Schedulers.boundedElastic())
          .toFuture()
          .get(5L, TimeUnit.SECONDS);

      country = user1.getCountry();
    }

    return webClient.get()
        .uri("https://corona.lmao.ninja/v2/countries/{country}", country)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
          if (clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
            return Mono.error(
                new WellnessWidgetException(HttpStatus.NOT_FOUND.value(), "Data not found"));
          }
          return clientResponse.bodyToMono(String.class).flatMap(responseMessage -> Mono.error(
              new WellnessWidgetException(clientResponse.statusCode().value(), responseMessage)));
        })
        .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
          if (clientResponse.statusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            return Mono.error(
                new WellnessWidgetException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Some internal server error - external api"));
          }
          return clientResponse.bodyToMono(String.class).flatMap(responseMessage -> Mono.error(
              new WellnessWidgetException(clientResponse.statusCode().value(), responseMessage)));
        })
        .bodyToMono(SicknessResponseVo.class);
  }
}
