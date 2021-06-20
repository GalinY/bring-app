package com.bring.bringParcel.services;

import com.bring.bringParcel.entities.Trip;
import com.bring.bringParcel.helpers.ExcelHelper;
import com.bring.bringParcel.repositories.TripRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExcelServiceImplTests {

  @Mock
  TripRepository mockTripRepository;

  @Mock
  ExcelHelper excelHelper;

  Trip trip = new Trip(1, "Oslo 1", "Norway", "55",
      "22:22", "Sweden", "33", "2020-10-24 01:57:37");
  List<Trip> trips = new ArrayList<>();

  @Test
  public void writeShouldCallRepository() {
    //given
    ExcelService excelService = new ExcelServiceImpl(mockTripRepository);
    trips.add(trip);

    //when
    Mockito.when(mockTripRepository.findAll()).thenReturn(trips);
    excelService.write();

    //then
    Mockito.verify(mockTripRepository, Mockito.times(1)).findAll();
  }

}
