package com.example.youbooking.services;

import com.example.youbooking.entities.Reservation;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IReservationService {
    public ResponseDTO addReservation(Reservation reservation);
    public ResponseDTO updateReservation(Reservation reservation);
    public ResponseDTO annulerReservation(Long idResrvation);
    public ResponseDTO findAllResrvations();
    public ResponseDTO findOneResrvation(Long idResrvation);
}
