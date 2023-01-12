package com.example.youbooking.repositories;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.StatusChamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChamberRepository extends JpaRepository<Chamber,Long> {
    @Query("select c from Chamber c, Hotel h, Adresse a, Reservation r " +
            "where c.statusChamber=:statusChamber " +
            "and c.id = r.chamber.id " +
            "and h.id = c.hotel.id and a.id = h.adresse.id " +
            "and h.adresse.ville =:ville " +
            "and r.chamber.id = r.id " +
            "and :dateDebut not BETWEEN r.dateDebut and r.dateFin")
    List<Chamber> findAllByStatusChamber(StatusChamber statusChamber, String ville, LocalDate dateDebut);
}
