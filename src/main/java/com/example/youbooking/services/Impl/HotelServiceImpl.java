package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService {
    @Override
    public ResponseDTO addHotel(Hotel hotel) {
        return null;
    }

    @Override
    public ResponseDTO updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public ResponseDTO findOneHotel(Long idHotel) {
        return null;
    }

    @Override
    public ResponseDTO findAllHotels() {
        return null;
    }

    @Override
    public ResponseDTO deleteHotel(Long idHotel) {
        return null;
    }
}
