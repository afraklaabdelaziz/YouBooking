package com.example.youbooking.services;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IHotelService {
    public ResponseDTO addHotel(Hotel hotel);
    public ResponseDTO updateHotel(Hotel hotel);
    public ResponseDTO findOneHotel(Long idHotel);
    public ResponseDTO findAllHotels();
    public ResponseDTO deleteHotel(Long idHotel);
}
