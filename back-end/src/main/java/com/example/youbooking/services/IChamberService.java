package com.example.youbooking.services;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusChamber;
import com.example.youbooking.services.dto.ResponseDTO;


public interface IChamberService {
    public ResponseDTO addChamber(Chamber chamber);
    public ResponseDTO updateChamber(Chamber chamber, Long idHotel);
    public ResponseDTO deleteChamber(Long idChamber);
    public ResponseDTO findAllChamber();
    public ResponseDTO findOneChamber(Long idChamber);
    ResponseDTO updateStatusChamber(Long idChamber, StatusChamber status);

    ResponseDTO allRoomsDesponible(Reservation reservation, String ville);

    Integer countRoom(String email);
}
