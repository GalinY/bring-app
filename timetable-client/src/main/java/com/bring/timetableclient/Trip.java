package com.bring.timetableclient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Trip {

  private Long id;
  private String name;
  private String origin;
  private String gate;
  private String arrival;
  private String destination;
  private String places;
  private String timestamp;


  public Trip(String name, String origin,
      String gate, String arrival, String destination, String places, String timestamp) {
    this.name = name;
    this.origin = origin;
    this.gate = gate;
    this.arrival = arrival;
    this.destination = destination;
    this.places = places;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getGate() {
    return gate;
  }

  public void setGate(String gate) {
    this.gate = gate;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getPlaces() {
    return places;
  }

  public void setPlaces(String places) {
    this.places = places;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "Trip{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", origin='" + origin + '\'' +
        ", gate='" + gate + '\'' +
        ", arrival='" + arrival + '\'' +
        ", destination='" + destination + '\'' +
        ", places='" + places + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}
