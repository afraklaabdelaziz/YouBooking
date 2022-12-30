package com.example.youbooking.controllers;

import com.example.youbooking.dto.HotelDto;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    IHotelService hotelService;

    @GetMapping
    public ResponseDTO getAll(){
        return hotelService.findAllHotels();
    }

    @GetMapping("/one/{id}")
    public ResponseDTO findOne(@PathVariable Long id){
        return hotelService.findOneHotel(id);
    }

    @PostMapping("/add")
    public ResponseDTO addChamber(@Valid HotelDto hotelDto){
        Hotel hotel = DtoToEntity.hoteDtoToHotel(hotelDto);
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateChamber(@Valid HotelDto hotelDto,@PathVariable Long id){
        hotelDto.setId(id);
        Hotel hotel = DtoToEntity.hoteDtoToHotel(hotelDto);
        return hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteChamber(@PathVariable Long id){
        return hotelService.deleteHotel(id);
    }
}
