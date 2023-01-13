package com.example.youbooking.controllers;

import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusChamber;
import com.example.youbooking.entities.StatusReservation;
import com.example.youbooking.services.IReservationService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:62250")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @GetMapping("allreservation")
    public List<Reservation> getAllReservation(){
    return reservationService.findAllResrvations();
    }

    @GetMapping("reservatinEncours")
    public List<Reservation> findReservationEncours(){
        return reservationService.findByStatus(StatusReservation.Encours);
    }

    @PutMapping("/updateStatusReservation/{id}/{status}")
    public ResponseDTO updateStatusReservation(@PathVariable Long id, @PathVariable StatusReservation status){
        return reservationService.updateStatusReservation(id,status);
    }
}
