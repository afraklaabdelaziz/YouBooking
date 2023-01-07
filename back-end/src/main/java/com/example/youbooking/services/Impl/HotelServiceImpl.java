package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.repositories.HotelRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    public HotelRepository hotelRepository;
    @Autowired
    IAdresseService adresseService;
    @Autowired
    IUserService userService;

    @Override
    public ResponseDTO addHotel(Hotel hotel) {
        if (hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is requred");
        }else {
            hotel.setStatus(Status.Desactive);
            adresseService.addAdressse(hotel.getAdresse());
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
    public ResponseDTO updateStatusHotel(Long idHotel) {
        Optional<Hotel> hotel = hotelRepository.findById(idHotel);
        if (!hotel.isPresent()){
            return new ResponseDTO("bad request","this hotel dont present");
        }else {
            hotel.get().setStatus(Status.Active);
            hotelRepository.save(hotel.get());
            return new ResponseDTO("success","hotel actived");
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

    @Override
    public ResponseDTO findHotelByProprietaire(Long idProprietaire, Status status) {
     return new ResponseDTO("success","hotels ",hotelRepository.findHotelByProprietaireAndStatus(idProprietaire,status));
    }

}
