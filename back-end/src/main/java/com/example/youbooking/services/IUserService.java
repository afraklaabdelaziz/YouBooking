package com.example.youbooking.services;

import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
    public ResponseDTO addUser(User user);
    public ResponseDTO updateUser(User user);
    public ResponseDTO bannerUser(Long idUser);
    public ResponseDTO findUser(Long idUser);
    public List<User> findAllUsers();

    public List<User> findUserByStatus(Status status);

    ResponseDTO findUserByTelephone(String telephone);

    UserDetails findUserByEmail(String email);

    ResponseDTO delete(Long idUser);

    ResponseDTO searchUser(String nom, String telephone, String email);
}
