package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Reservation;
import com.example.youbooking.repositories.ReservationRepository;
import com.example.youbooking.services.IReservationService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
   public ReservationRepository reservationRepository;

    @Override
    public ResponseDTO addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public ResponseDTO updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public ResponseDTO annulerReservation(Long idResrvation) {
        return null;
    }

    @Override
    public ResponseDTO findAllResrvations() {
        return null;
    }

    @Override
    public ResponseDTO findOneResrvation(Long idResrvation) {
        return null;
    }
}
