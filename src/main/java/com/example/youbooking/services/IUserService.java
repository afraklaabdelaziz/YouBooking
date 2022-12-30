package com.example.youbooking.services;

import com.example.youbooking.entities.User;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IUserService {
    public ResponseDTO addUser(User user);
    public ResponseDTO updateUser(User user);
    public ResponseDTO bannerUser(Long idUser);
    public ResponseDTO findUser(Long idUser);
    public ResponseDTO findAllUsers();

    ResponseDTO findUserByTelephone(String telephone);

    ResponseDTO findUserByEmail(String email);
}
