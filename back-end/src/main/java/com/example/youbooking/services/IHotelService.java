package com.example.youbooking.services;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface IHotelService {
    public ResponseDTO addHotel(Hotel hotel, String email,MultipartFile file);
    public ResponseDTO updateHotel(Hotel hotel);
    public ResponseDTO updateStatusHotel(Long idHotel);
    public ResponseDTO findOneHotel(Long idHotel);
    public List<Hotel> findAllHotels();
    public ResponseDTO deleteHotel(Long idHotel);
    public List<Hotel> findHotelsByStatus(Status status);

    ResponseDTO findHotelByProprietaire(String email);

    List<Hotel> findByCriteria(String nom, String tele,String ville);

}
