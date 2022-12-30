package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.User;
import com.example.youbooking.repositories.UserRepository;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseDTO addUser(User user) {
        if(user == null || user == new User()){
            return new ResponseDTO("bad request","information is required");

        }else if (this.findUserByTelephone(user.getTelephone()).getData() != null ){
            return new ResponseDTO("bad request","this user with this phone is present");

        }else if(this.findUserByEmail(user.getEmail()).getData() != null){
            return new ResponseDTO("bad request","user with this email is present");

        }else {
            return new ResponseDTO("success","user is added",user);
        }

    }

    @Override
    public ResponseDTO updateUser(User user) {
        if(user == null || user == new User()){
            return new ResponseDTO("bad request","room is required");
        }else {
            User userFind = userRepository.findById(user.getId()).get();
            userFind.setEmail(user.getEmail());
            userFind.setNom(user.getNom());
            userFind.setPassword(user.getPassword());
            userFind.setTelephone(user.getTelephone());
            return new ResponseDTO("success","your profile is updated",userFind);
        }
    }

    @Override
    public ResponseDTO bannerUser(Long idUser) {
        User user = userRepository.findById(idUser).get();
        if(user == null){
            return new ResponseDTO("bad request","this user dont present");
        }else{
            userRepository.delete(user);
            return new ResponseDTO("success","success",user);
        }
    }

    @Override
    public ResponseDTO findUser(Long idUser) {
        User user = userRepository.findById(idUser).get();
        if(user == null){
            return new ResponseDTO("bad request","this user dont present");
        }
        return new ResponseDTO("success","your room ",user);
    }


    @Override
    public ResponseDTO findAllUsers() {
        return new ResponseDTO("success","rooms",userRepository.findAll());
    }

    @Override
    public ResponseDTO findUserByTelephone(String telephone){
        User user = userRepository.findUserByTelephone(telephone);
        if(user == null){
            return new ResponseDTO("bad request","this user dont present");

        }else {
            return new ResponseDTO("success","user",user);
        }
    }

    @Override
    public ResponseDTO findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            return new ResponseDTO("bad request","this user dont present");

        }else {
            return new ResponseDTO("success","user",user);
        }
    }
}
