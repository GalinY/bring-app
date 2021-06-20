package com.bring.bringParcel.repositories;

import com.bring.bringParcel.entities.Trip;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Long> {

  @Transactional
  List<Trip> findAll(Sort sort);

  @Query(value = "SELECT * FROM trips t \n"
      + "WHERE t.name LIKE %?1% \n"
      + "AND t.origin= ?2\n"
      + "AND t.gate= ?3\n"
      + "AND t.arrival LIKE ?4%\n"
      + "AND t.destination LIKE ?5%\n"
      + "AND t.destination LIKE ?6"
      , nativeQuery = true)
//  @Query("SELECT t FROM Trip t WHERE t.name LIKE %?1% and t.origin = ?2 and t.gate=?3 and t.arrival CONTAINS ?4")
  List<Trip> findByNameAndOriginAndGateAndArrival(String name, String origin, String gate,
      String arrival, String destination, String places);
}
