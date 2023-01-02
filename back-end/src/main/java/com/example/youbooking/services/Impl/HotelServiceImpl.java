package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.repositories.HotelRepository;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    public HotelRepository hotelRepository;

    @Override
    public ResponseDTO addHotel(Hotel hotel) {
        if (hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is requred");
        }else {
            hotel.setStatus(Status.Desactive);
            hotelRepository.save(hotel);
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
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
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

    @Override
    public List<Hotel> findHotelsByStatus(Status status) {
        return hotelRepository.findHotelByStatus(status);
    }
}
