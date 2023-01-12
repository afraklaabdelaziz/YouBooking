package com.example.youbooking.services;

import com.example.youbooking.entities.Adresse;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IHotelService {
    public ResponseDTO addHotel(Hotel hotel);
    public ResponseDTO updateHotel(Hotel hotel);
    public ResponseDTO updateStatusHotel(Long idHotel);
    public ResponseDTO findOneHotel(Long idHotel);
    public List<Hotel> findAllHotels();
    public ResponseDTO deleteHotel(Long idHotel);
    public List<Hotel> findHotelsByStatus(Status status);

    ResponseDTO findHotelByProprietaire(Long idProprietaire);

    List<Hotel> findByCriteria(String nom, String tele,String ville);
}
