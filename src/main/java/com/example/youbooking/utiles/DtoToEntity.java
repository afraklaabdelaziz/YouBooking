package com.example.youbooking.utiles;

import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.User;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static User userDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, User.class);
    }
}
