package com.example.youbooking.repositories;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    public List<Reservation> findReservationByClientAndStatusReservation(Long idClient, StatusReservation status);

    public List<Reservation> findReservationByStatusReservation(StatusReservation status);

    public List<Reservation> findReservationByChamberAndStatusReservation(Long idChmaber,StatusReservation status);

    @Query("select r from Reservation r where r.chamber.hotel.proprietaire.id = :idOwner")
    List<Reservation> findAllReservationOfHotelOwner(Long idOwner);

    @Query("select r from Reservation r where r.chamber.hotel.proprietaire.id = :idOwner and r.statusReservation = :status")
    List<Reservation> findAllReservationOfHotelOwnerAndStatusEncours(Long idOwner,StatusReservation status);

    public Reservation findReservationByChamberAndDateDebutAndAndDateFinAndStatusReservation(
            Chamber chamber
            , LocalDate dateDebut
            ,LocalDate dateFin
            ,StatusReservation status);
}



