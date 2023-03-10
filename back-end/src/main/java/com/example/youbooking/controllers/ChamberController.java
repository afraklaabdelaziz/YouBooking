package com.example.youbooking.controllers;

import com.example.youbooking.dto.ChamberDto;
import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusChamber;
import com.example.youbooking.services.IChamberService;
import com.example.youbooking.services.IReservationService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chamber")
@CrossOrigin("http://localhost:62250")
public class ChamberController {

    @Autowired
    IChamberService chamberService;
    @Autowired
    IReservationService reservationService;

    @GetMapping
    public ResponseDTO getAll(){
        return chamberService.findAllChamber();
    }

    @GetMapping("/one/{id}")
    public ResponseDTO findOne(@PathVariable Long id){
        return chamberService.findOneChamber(id);
    }

    @PostMapping("/add")
    public ResponseDTO addChamber(@Valid @RequestBody ChamberDto chamberDto){
        Chamber chamber = DtoToEntity.chamberDtoToChamber(chamberDto);
        return chamberService.addChamber(chamber);
    }

    @PutMapping("/update/{id}/{idHotel}")
    public ResponseDTO updateChamber(@Valid @RequestBody ChamberDto chamberDto,@PathVariable Long id,@PathVariable Long idHotel){
        chamberDto.setId(id);
        Chamber chamber = DtoToEntity.chamberDtoToChamber(chamberDto);
        return chamberService.updateChamber(chamber,idHotel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteChamber(@PathVariable Long id){
        return chamberService.deleteChamber(id);
    }

    @PostMapping("/reserver/{idChamber}/{idClient}")
    public ResponseDTO resrever(@RequestBody Reservation reservation,@PathVariable Long idChamber,@PathVariable Long idClient){
        return reservationService.addReservation(reservation,idChamber,idClient);
    }


    @PostMapping("/roomDespo/{ville}")
    public ResponseDTO allReservation(@RequestBody Reservation reservation,@PathVariable String ville){
        return chamberService.allRoomsDesponible(reservation,ville);
    }

    @GetMapping("/countRooms/{email}")
    public Integer countRooms(@PathVariable  String email){
        return chamberService.countRoom(email);
    }

}
