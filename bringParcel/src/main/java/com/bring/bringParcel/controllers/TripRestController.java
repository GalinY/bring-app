package com.bring.bringParcel.controllers;

import com.bring.bringParcel.entities.Trip;
import com.bring.bringParcel.exceptions.CustomException;
import com.bring.bringParcel.services.TripService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/trips")
public class TripRestController {

  private TripService tripService;

  @Autowired
  public TripRestController(TripService tripService) {
    this.tripService = tripService;
  }

  @GetMapping
  public ResponseEntity<List<Trip>> getTrips() {
    try {
      List<Trip> trips = tripService.getTrips();
      return ResponseEntity.ok().body(trips);
    } catch (CustomException e) {
      throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<Void> createTrip(@Valid @RequestBody Trip trip) {
    tripService.createTrip(trip);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  ResponseEntity<Void> editTrip(@Valid @RequestBody Trip trip) {
    tripService.editTrip(trip, trip.getId());
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @DeleteMapping
  public ResponseEntity<Long> deleteTrip(@Valid @RequestBody Trip trip) {
    tripService.delete(trip.getId());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/clear")
  public ResponseEntity<Void> deleteAllTrips() {
    tripService.deleteAllTrips();
    return new ResponseEntity<>(HttpStatus.OK);
  }

//  @GetMapping("/")
//  public ResponseEntity<List<Trip>> getAllByName(
//      @RequestParam(value = "name", required = false) String name,
//      @RequestParam(value = "origin", required = false) String origin,
//      @RequestParam(value = "gate", required = false) String gate,
//      @RequestParam(value = "arrival", required = false) String arrival) {
//    try {
//      List<Trip> filteredTrips = tripService
//          .filterAll(name, origin, gate, arrival);
//      return ResponseEntity.ok().body(filteredTrips);
//    } catch (CustomException e) {
//      throw new CustomException(e.getMessage(), e.getHttpStatus());
//    }
//  }
 @GetMapping("/")
  public ResponseEntity<List<Trip>> getAllByName(@RequestParam(value = "name") String name) {
    try {
      List<Trip> filteredTrips = tripService.getAllByName(name);
      return ResponseEntity.ok().body(filteredTrips);
    } catch (CustomException e) {
      throw new CustomException(e.getMessage(), e.getHttpStatus());
    }
  }
}
