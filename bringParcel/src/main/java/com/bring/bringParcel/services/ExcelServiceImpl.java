package com.bring.bringParcel.services;

import com.bring.bringParcel.entities.Trip;
import com.bring.bringParcel.helpers.ExcelHelper;
import com.bring.bringParcel.repositories.TripRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService {

//  @Autowired
  private final TripRepository tripRepository;

  @Autowired
   public ExcelServiceImpl(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  public void write() {
    List<Trip> trips = tripRepository.findAll();
    ExcelHelper.tripsToExcel(trips);
  }

//public ByteArrayInputStream load() {
//    List<Trip> trips = tripRepository.findAll();
//    ByteArrayInputStream in = ExcelHelper.tripsToExcel(trips);
//    return in;
//  }
}
