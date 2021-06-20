package com.bring.timetableclient;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Log4j2
public class WebTimetableClient {

  @Autowired
  private final WebClient webClient;

  public WebTimetableClient(WebClient webClient) {
    this.webClient = webClient;
  }

  public List<Trip> getTrips() {
    return webClient
        .get()
        .uri("http://localhost:8081/trips")
        .retrieve()
        .bodyToFlux(Trip.class)
        .collectList()
        .block();
  }

  public void createTrip(Trip trip) {
    webClient
        .post()
        .uri("http://localhost:8081/trips")
        .body(Mono.just(trip), Trip.class)
        .retrieve()
        .bodyToMono(Trip.class)
        .block();
  }

  public void deleteTrip(Trip trip) {
    webClient
        .method(HttpMethod.DELETE)
        .uri("http://localhost:8081/trips")
        .body(Mono.just(trip), Trip.class)
        .retrieve()
        .bodyToMono(Trip.class)
        .block();
  }

  public void deleteAllTrips() {
    webClient
        .method(HttpMethod.DELETE)
        .uri("http://localhost:8081/trips/clear")
        .retrieve()
        .bodyToFlux(Void.class)
        .collectList()
        .block();
  }

  public void editTrip(Trip trip) {
    webClient
        .method(HttpMethod.PUT)
        .uri("http://localhost:8081/trips")
        .body(Mono.just(trip), Trip.class)
        .retrieve()
        .bodyToMono(Trip.class)
        .block();
  }

  public void generateNightReport() {
    webClient.post()
        .uri("http://localhost:8081/excel/night-report")
        .retrieve()
        .bodyToFlux(Void.class)
        .collectList()
        .block();
  }

  public List<Trip> getAllByName(String name) {
    return this.webClient
        .get()
        .uri("http://localhost:8081/trips/?name=" +name)
        .retrieve()
        .bodyToFlux(Trip.class)
        .collectList()
        .block();
  }
}
