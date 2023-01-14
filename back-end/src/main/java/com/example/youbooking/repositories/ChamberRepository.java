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

    @Query("select r.chamber from Reservation r where r.chamber.hotel.adresse.ville = :ville " +
            " and ((:dateDebut not BETWEEN r.dateDebut and r.dateFin)" +
            " or (:dateFin not between r.dateDebut and r.dateFin))" )
    public List<Chamber> findListRoomNoReservedInDate(LocalDate dateDebut,LocalDate dateFin,String ville);
    @Query("select c from Chamber c where c.reservationList.size = 0 and c.hotel.adresse.ville = :ville ")
    public List<Chamber> findAllByVilleNoReserved(String ville);
}
