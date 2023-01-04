package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.repositories.UserRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public IAdresseService adresseService;

    @Override
    public ResponseDTO addUser(User user) {
        if(user == null || user == new User()){
            return new ResponseDTO("bad request","information is required");

        }else if (this.findUserByTelephone(user.getTelephone()).getData() != null ){
            return new ResponseDTO("bad request","this user with this phone is present");

        }else if(this.findUserByEmail(user.getEmail()) != null){
            return new ResponseDTO("bad request","user with this email is present");

        }else {
            adresseService.addAdressse(user.getAdresse());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseDTO("success","user is added",user);
        }

    }

    @Override
    public ResponseDTO updateUser(User user) {
        if(user == null || user == new User()){
            return new ResponseDTO("bad request","information  is required");
        }else {
            User userFind = userRepository.findById(user.getId()).get();
            userFind.setEmail(user.getEmail());
            userFind.setNom(user.getNom());
            userFind.setPassword(user.getPassword());
            userFind.setTelephone(user.getTelephone());
            userFind.setAdresse(user.getAdresse());
            adresseService.updateAdresse(user.getAdresse());
            userRepository.save(user);
            return new ResponseDTO("success","your profile is updated",userFind);
        }
    }

    @Override
    public ResponseDTO bannerUser(Long idUser) {
        User user = userRepository.findById(idUser).get();
        if(user == null){
            return new ResponseDTO("bad request","this user dont present");
        }else{
            user.setStatus(Status.Desactive);
            userRepository.save(user);
            return new ResponseDTO("success", user.getNom()+" is ban",user);
        }
    }

    @Override
    public ResponseDTO findUser(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(!user.isPresent()){
            return new ResponseDTO("bad request","this user dont present");
        }
        return new ResponseDTO("success","profile of user ",user);
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserByStatus(Status status) {
        return userRepository.findUserByStatus(status);
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
    public UserDetails findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user == null){
           return null;

        }else {

           return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),Collections.singleton(new SimpleGrantedAuthority(user.getRole().getNom())));
        }
        }
}
