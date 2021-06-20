//package com.bring.timetableclient;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.web.reactive.function.client.WebClient;
//
//class WebTimetableClientIntegrationTest {
//
//  private WebClient webClient = WebClient.builder().build();
//
//
//  @Test
//  void shouldRetrieveTripsFromTripService() {
//    //given
//    WebTimetableClient webTimetableClient = new WebTimetableClient(webClient);
//
//    //when
//    List<Trip> trips = webTimetableClient.getTrips();
//
//    //then
//    Assertions.assertNotNull(trips);
//
//    Assertions.assertEquals(6, trips.size());
//    Assertions.assertEquals("ALSO 3", trips.get(0).getName());
//  }
//
//  @Test
//  void shouldCreateTrip() {
//    //given
//    WebTimetableClient webTimetableClient = new WebTimetableClient(webClient);
//
//    //when
//    //webTimetableClient.createTrip();
//
//    //then
//
//  }
//
//  @Test
//  void shouldEditTrip() {
//    //given
//    WebTimetableClient webTimetableClient = new WebTimetableClient(webClient);
//    Trip trip = new Trip("test", "test", "test", "test", LocalDateTime.now().toString());
//
//    //when
//    webTimetableClient.editTrip(trip);
//
//    //then
//
//  }
//
//
//}
//
