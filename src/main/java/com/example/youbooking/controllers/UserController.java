package com.example.youbooking.controllers;

import com.example.youbooking.dto.AdresseDto;
import com.example.youbooking.dto.LoginDto;
import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.Adresse;
import com.example.youbooking.entities.User;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/add")
    public ResponseDTO register(@Valid UserDto userDto){
        User user = DtoToEntity.userDtoToUser(userDto);
        return userService.addUser(user);
    }

}
