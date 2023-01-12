package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.repositories.UserRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.SpecificationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            Optional <User> userFind = userRepository.findById(user.getId());
            if (userFind.isPresent()){

                System.out.println(user.getEmail());

                userFind.get().setEmail(user.getEmail());
                userFind.get().setNom(user.getNom());

                userFind.get().setPassword(user.getPassword());
                userFind.get().setTelephone(user.getTelephone());

                user.getAdresse().setId(userFind.get().getAdresse().getId());
                adresseService.updateAdresse(user.getAdresse());

                userFind.get().setAdresse(user.getAdresse());
                userRepository.save(userFind.get());
                return new ResponseDTO("success","your profile is updated",userFind);
            }else {
                return new ResponseDTO("bad request","this user dont present");
            }

        }
    }

    @Override
    public ResponseDTO bannerUser(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(!user.isPresent()){
            return new ResponseDTO("bad request","this user dont present");
        }else{
            if (user.get().getStatus().equals(Status.Active)){
                user.get().setStatus(Status.Desactive);
            }else {
                user.get().setStatus(Status.Active);
            }

            userRepository.save(user.get());
            return new ResponseDTO("success", user.get().getNom()+" is ban",user);
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

@Transactional
    @Override
    public ResponseDTO delete(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(!user.isPresent()){
            return new ResponseDTO("bad request","this user dont present");
        }else{
            userRepository.delete(user.get());
            return new ResponseDTO("success", user.get().getNom()+" is ban",user);
        }
    }

    @Override
    public ResponseDTO searchUser(String nom, String telephone, String email){
        List<User> users =  userRepository.findAll(SpecificationCriteria.searchUser(nom,telephone,email));
        return new ResponseDTO("success","users Found",users);
    }
}
