package com.example.youbooking.controllers;

import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.Admin;
import com.example.youbooking.entities.Client;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.services.IAdminService;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.IProprietaireService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;
    @Autowired
    IProprietaireService proprietaireService;
    @Autowired
    IHotelService hotelService;


    @PutMapping("/updateStatusHotel/{id}")
    public ResponseDTO updateStausHotel(@PathVariable Long id){
        return hotelService.updateStatusHotel(id);
    }

    @GetMapping("/propritaireDesactiver")
    public ResponseDTO findPropritaireDesactive(){
    return  proprietaireService.findPropritaireByStatusDesactive(Status.Desactive);
    }
    @PutMapping("/updateStatuspropritaire/{id}")
    public ResponseDTO acceptePropritaire(@PathVariable Long id){
        return adminService.acceptePropritaire(id);
    }

    @PostMapping("/add")
    public ResponseDTO addAdmin(@RequestBody UserDto userDto){
        Admin admin =  DtoToEntity.adminDtoToUser(userDto);
        return adminService.add(admin);
    }
}
