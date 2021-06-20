package com.bring.bringParcel.services;

import com.bring.bringParcel.entities.Trip;
import java.util.List;

public interface TripService {

  List<Trip> getTrips();

  void createTrip(Trip trip);

  void editTrip(Trip trip, Long id);

  void delete(Long id);

  void deleteAllTrips();

  List<Trip> getAllByName(String name);

  List<Trip> filterAll(String name, String origin, String gate, String arrival, String destination, String places);
}
