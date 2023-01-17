package com.example.youbooking.services;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusReservation;
import com.example.youbooking.services.dto.ResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    public ResponseDTO addReservation(Reservation reservation, Long idChamber, Long idClient);
    public ResponseDTO updateReservation(Reservation reservation);
    public ResponseDTO annulerReservation(Long idResrvation);
    public List<Reservation> findAllResrvations();

    List<Reservation> findAllReservationOfHotelOwner(String email);

    public ResponseDTO findOneResrvation(Long idResrvation);
    public List<Reservation> findByClientAndStatus(String email);

    List<Reservation> findByStatus(String email);

    public List<Reservation> findReservationByChamberAndStatusReservation(Long idChamber, StatusReservation status);

    public Reservation findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
            Chamber chamber
            ,LocalDate dateDebut
            ,LocalDate dateFin
            ,StatusReservation status);

    ResponseDTO updateStatusReservation(Long idReservation, StatusReservation status);
}
