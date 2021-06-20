package com.bring.timetableclient;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

  @Bean
  public WebTimetableClient webTimetableClient(
      WebClient webTimetableClient) {
    return new WebTimetableClient(webTimetableClient);
  }

  @Bean
  @ConditionalOnMissingBean
  public WebClient webClient() {
    return WebClient.builder().build();
  }
}
