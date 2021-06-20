package com.bring.bringParcel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trips")
@NoArgsConstructor
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Size(min = 3, max = 20, message = "Name should be between 3 and 20!")
  @Column(name = "name")
  private String name;

  @Size(min = 3, max = 20, message = "Origin should be between 3 and 20!")
  @Column(name = "origin")
  private String origin;

  @Size(min = 1, max = 3, message = "Gate should be between 1 and 3 characters!")
  @Column(name = "gate")
  private String gate;

  @Size(min = 1, max = 20, message = "Arrival should be between 4 and 20 characters!")
  @Column(name = "arrival")
  private String arrival;

  @Size(min = 1, max = 20, message = "Destination should be between 4 and 20 characters!")
  @Column(name = "destination")
  private String destination;

  @Size(min = 1, max = 3, message = "Places should be between 1 and 3 characters!")
  @Column(name = "places")
  private String places;

  @Column(name = "timestamp")
  private String timestamp;

  public Trip(long id,
      @Size(min = 3, max = 20, message = "Name should be between 3 and 20!") String name,
      @Size(min = 3, max = 20, message = "Origin should be between 3 and 20!") String origin,
      @Size(min = 1, max = 3, message = "Gate should be between 1 and 3 characters!") String gate,
      @Size(min = 4, max = 20, message = "Arrival should be between 4 and 20 characters!") String arrival,
      @Size(min = 4, max = 20, message = "Destination should be between 4 and 20 characters!") String destination,
      @Size(min = 1, max = 3, message = "Places should be between 1 and 3 characters!") String places,
      String timestamp) {
    this.id = id;
    this.name = name;
    this.origin = origin;
    this.gate = gate;
    this.arrival = arrival;
    this.destination = destination;
    this.places = places;
    this.timestamp = timestamp;
  }

  public long getId() {
    return id;
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
        "name='" + name + '\'' +
        ", origin='" + origin + '\'' +
        ", gate='" + gate + '\'' +
        ", arrival='" + arrival + '\'' +
        ", destination='" + destination + '\'' +
        '}';
  }
}
