package com.example.youbooking.utiles;

import com.example.youbooking.dto.AdresseDto;
import com.example.youbooking.dto.ChamberDto;
import com.example.youbooking.dto.HotelDto;
import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.*;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static User userDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, User.class);
    }

    public static Client clientDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, Client.class);
    }

    public static Proprietaire propritaireDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, Proprietaire.class);
    }

    public static Chamber chamberDtoToChamber(ChamberDto chamberDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(chamberDto, Chamber.class);
    }

    public static Hotel hoteDtoToHotel(HotelDto hotelDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(hotelDto, Hotel.class);
    }

    public static Adresse adresseDtoToAdresse(AdresseDto adresseDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(adresseDto, Adresse.class);
    }

}
