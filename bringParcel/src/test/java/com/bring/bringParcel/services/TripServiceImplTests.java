package com.bring.bringParcel.services;

import com.bring.bringParcel.entities.Trip;
import com.bring.bringParcel.exceptions.CustomException;
import com.bring.bringParcel.repositories.TripRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceImplTests {

  @Mock
  private TripRepository mockTripRepository;

  private final Trip trip = new Trip(1, "Oslo 1", "Norway", "55",
      "22:22", "Sweden", "33", "2020-10-24 01:57:37");
  private final List<Trip> trips = new ArrayList<>();
  private Long id = 1L;

  @Test
  public void createTripShouldSaveTrip() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);

    //when
    tripService.createTrip(trip);

    //then
    Mockito.verify(mockTripRepository, Mockito.times(1)).save(trip);
  }

  @Test
  public void getTripsShouldReturnTrips() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);
    List<Trip> trips1;

    //when
    trips1 = tripService.getTrips();

    //then
    Assert.assertArrayEquals(trips.toArray(), trips1.toArray());
  }

  @Test
  public void editTripShouldCallRepository() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);
    trips.add(trip);
    Mockito.when(mockTripRepository.findAllById(Collections.singleton(id))).thenReturn(trips);

    //when
    tripService.editTrip(trip, id);

    //then
    Mockito.verify(mockTripRepository, Mockito.times(1)).save(trip);
  }

  @Test(expected = CustomException.class)
  public void editTripShouldThrowExceptionIfNoTrip() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);

    //when
    tripService.editTrip(trip, id);
  }

  @Test(expected = CustomException.class)
  public void deleteShouldThrowExceptionIfEmpty() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);

    //when
    tripService.delete(0L);
  }

  @Test
  public void deleteShouldCallRepository() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);
    trips.add(trip);

    //when
    Mockito.when(mockTripRepository.findAllById(Collections.singleton(id))).thenReturn(trips);
    tripService.delete(trips.get(0).getId());

    //then
    Mockito.verify(mockTripRepository, Mockito.times(1)).delete(trips.get(0));
  }

  @Test
  public void deleteAllTrips() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);

    //when
    tripService.deleteAllTrips();

    //then
    Mockito.verify(mockTripRepository, Mockito.times(1)).deleteAll();
  }

  @Test
  public void getAllByName() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);
    trips.add(trip);
    List<Trip> tripsToCheck;

    //when
    Mockito.when(mockTripRepository.findAll()).thenReturn(trips);
    tripsToCheck = tripService.getAllByName("Oslo 1");

    //then
    Assert.assertArrayEquals(trips.toArray(), tripsToCheck.toArray());
  }

  @Test
  public void filterAll() {
    //given
    TripService tripService = new TripServiceImpl(mockTripRepository);
    trips.add(trip);
    List<Trip> tripsToCheck;

    //when
    Mockito.when(mockTripRepository.findByNameAndOriginAndGateAndArrival("Oslo 1", "Norway", "55",
        "22:22", "Sweden", "33")).thenReturn(trips);
    tripsToCheck = tripService.filterAll("Oslo 1", "Norway", "55", "22:22", "Sweden", "33");

    Assert.assertArrayEquals(trips.toArray(), tripsToCheck.toArray());
  }
}
