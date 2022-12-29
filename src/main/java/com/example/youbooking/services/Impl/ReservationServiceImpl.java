package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Reservation;
import com.example.youbooking.services.IReservationService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {
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
