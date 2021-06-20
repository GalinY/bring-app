package com.bring.bringParcel.services;


import com.bring.bringParcel.entities.Trip;
import com.bring.bringParcel.exceptions.CustomException;
import com.bring.bringParcel.repositories.TripRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class TripServiceImpl implements TripService {

  private final TripRepository tripRepository;

  @Autowired
  public TripServiceImpl(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  @Override
  public List<Trip> getTrips() {
    List<Trip> trips = tripRepository.findAll(Sort.by(Direction.DESC, "id"));
//    trips.sort(Comparator.comparing(Trip::getTimestamp).reversed());
    return trips;
  }

  @Override
  public void createTrip(Trip trip) {
    tripRepository.save(trip);
  }

  @Override
  public void editTrip(Trip trip, Long id) {
    List<Trip> trips = tripRepository.findAllById(Collections.singleton(id));

    if (trips.size() != 1) {
      throw new CustomException("Trip not found!", HttpStatus.NOT_FOUND);
    }

    trips.get(0).setName(trip.getName());
    trips.get(0).setOrigin(trip.getOrigin());
    trips.get(0).setGate(trip.getGate());
    trips.get(0).setArrival(trip.getArrival());
    trips.get(0).setDestination(trip.getDestination());
    trips.get(0).setPlaces(trip.getPlaces());

    tripRepository.save(trips.get(0));
  }

  @Override
  public void delete(Long id) {
    List<Trip> trips = tripRepository.findAllById(Collections.singleton(id));

    if (trips.size() != 1) {
      throw new CustomException("Trip not found!", HttpStatus.NOT_FOUND);
    }
    tripRepository.delete(trips.get(0));
  }

  @Override
  public void deleteAllTrips() {
    tripRepository.deleteAll();
  }

  @Override
  public List<Trip> getAllByName(String input) {
    List<Trip> trips = tripRepository.findAll();
    return trips.stream()
        .filter(t -> t.getName().contains(input))
        .collect(Collectors.toList());
  }

  @Override
  public List<Trip> filterAll(String name, String origin, String gate,
      String arrival, String destination, String places) {
    return tripRepository.findByNameAndOriginAndGateAndArrival(name, origin, gate, arrival, destination, places);
  }
}
