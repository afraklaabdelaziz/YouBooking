package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.User;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public ResponseDTO addUser(User user) {
        return null;
    }

    @Override
    public ResponseDTO updateUser(User user) {
        return null;
    }

    @Override
    public ResponseDTO bannerUser(Long idUser) {
        return null;
    }

    @Override
    public ResponseDTO findUser(Long idUser) {
        return null;
    }

    @Override
    public ResponseDTO findAllUsers() {
        return null;
    }
}
