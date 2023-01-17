package com.example.youbooking.controllers;

import com.example.youbooking.dto.HotelDto;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Image;
import com.example.youbooking.entities.Status;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("http://localhost:62250")
public class HotelController {

    @Autowired
    IHotelService hotelService;

    @GetMapping
    public List<Hotel> getAll(){
        return hotelService.findAllHotels();
    }

    @GetMapping("/hotelDesactive")
    public List<Hotel> findHotelsByStatusDesactive(){
        return hotelService.findHotelsByStatus(Status.Desactive);
    }

    @GetMapping("/proprietair/{email}")
    public ResponseDTO findHotelByPropritaire(@PathVariable String email){
        return hotelService.findHotelByProprietaire(email);
    }

    @GetMapping("/all")
    public List<Hotel> findAllHotels(){
        return hotelService.findAllHotels();
    }

    @GetMapping("/one/{id}")
    public ResponseDTO findOne(@PathVariable Long id){
        return hotelService.findOneHotel(id);
    }

    @PostMapping(value = {"/add/{email}"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDTO addChamber(@Valid @RequestPart("hotel") HotelDto hotelDto,
                                  @RequestPart(value = "imageFile",required = false) MultipartFile file,
                                  @PathVariable String email){
        Hotel hotel = DtoToEntity.hoteDtoToHotel(hotelDto);
        return hotelService.addHotel(hotel,email,file);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateChamber(@Valid @RequestBody HotelDto hotelDto,@PathVariable Long id){
        hotelDto.setId(id);
        Hotel hotel = DtoToEntity.hoteDtoToHotel(hotelDto);
        return hotelService.updateHotel(hotel);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteChamber(@PathVariable Long id){
        return hotelService.deleteHotel(id);
    }

    @PutMapping("updateStatusHotel/{id}")
    public ResponseDTO updateStatus(@PathVariable Long id){
        return hotelService.updateStatusHotel(id);
    }

    @GetMapping("/search")
    public List<Hotel> searchHotel(@RequestParam(value = "nom",required = false) String nom
                                   ,@RequestParam(value = "prix",required = false) String  tele
                                    ,@RequestParam(value = "ville",required = false) String ville ){
    return hotelService.findByCriteria(nom, tele,ville);
    }

}
