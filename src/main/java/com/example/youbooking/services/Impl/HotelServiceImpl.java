package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.repositories.HotelRepository;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    public HotelRepository hotelRepository;

    @Override
    public ResponseDTO addHotel(Hotel hotel) {
        if (hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is requred");
        }else {
            return new ResponseDTO("success","your hotel is added",hotel);
        }

    }

    @Override
    public ResponseDTO updateHotel(Hotel hotel) {
        if(hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is required");
        }else {
            Hotel hotelFind = hotelRepository.findById(hotel.getId()).get();
            hotelFind.setNom(hotelFind.getNom());
            hotelFind.setTelephone(hotel.getTelephone());
            hotelFind.setStatus(hotel.getStatus());
            return new ResponseDTO("success","your hotel is updated",hotelFind);
        }
    }

    @Override
    public ResponseDTO findOneHotel(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).get();
        if(hotel == null){
            return new ResponseDTO("bad request","this hotel dont present");
        }
        return new ResponseDTO("success","your hotel ",hotel);
    }

    @Override
    public ResponseDTO findAllHotels() {
        return new ResponseDTO("success","hotels",hotelRepository.findAll());
    }

    @Override
    public ResponseDTO deleteHotel(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).get();
        if(hotel == null){
            return new ResponseDTO("bad request","this hotel dont present");
        }else{
            hotelRepository.delete(hotel);
            return new ResponseDTO("success","hotel is delete",hotel);
        }
    }
}
