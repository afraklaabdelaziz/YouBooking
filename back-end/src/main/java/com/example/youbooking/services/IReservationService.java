package com.example.youbooking.services;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusReservation;
import com.example.youbooking.services.dto.ResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    public ResponseDTO addReservation(Reservation reservation);
    public ResponseDTO updateReservation(Reservation reservation);
    public ResponseDTO annulerReservation(Long idResrvation);
    public ResponseDTO findAllResrvations();
    public ResponseDTO findOneResrvation(Long idResrvation);
    public List<Reservation> findByClientAndStatus(Long idClient,StatusReservation status);
    public List<Reservation> findByStatus(StatusReservation status);

    public List<Reservation> findReservationByChamberAndStatusReservation(Long idChamber, StatusReservation status);

    public Reservation findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
            Chamber chamber
            ,LocalDate dateDebut
            ,LocalDate dateFin
            ,StatusReservation status);
}
