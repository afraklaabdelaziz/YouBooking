package com.example.youbooking.controllers;

import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.*;
import com.example.youbooking.repositories.ClientRepository;
import com.example.youbooking.services.IClientService;
import com.example.youbooking.services.IProprietaireService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:62250")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
   IClientService clientService;
    @Autowired
    IProprietaireService proprietaireService;

    @GetMapping
    public ResponseDTO allUsers(){
        return new ResponseDTO("sucesss","users users",userService.findAllUsers());
    }


    @GetMapping("/usersBan")
    public List<User> findHotelsByStatusDesactive(){
        return userService.findUserByStatus(Status.Desactive);
    }

    @PostMapping("/add")
    public ResponseDTO register(@Valid @RequestBody UserDto userDto){
        User user = DtoToEntity.userDtoToUser(userDto);
        if (user.getRole().getNom().equals("client")){
            Client client = DtoToEntity.clientDtoToUser(userDto);
             clientService.addClient(client);
             return new ResponseDTO("success","success",client);
        }else if(user.getRole().getNom().equals("propritaire")){
            Proprietaire proprietaire = DtoToEntity.propritaireDtoToUser(userDto);
            return proprietaireService.addPropritaire(proprietaire);
        }
        return userService.addUser(user);
    }

}
