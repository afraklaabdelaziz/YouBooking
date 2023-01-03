package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Client;
import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import com.example.youbooking.repositories.ClientRepository;
import com.example.youbooking.repositories.ProprietaireRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IClientService;
import com.example.youbooking.services.IProprietaireService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietaireServiceImpl implements IProprietaireService {
        @Autowired
        IUserService userService;
        @Autowired
        IAdresseService adresseService;
        @Autowired
        ProprietaireRepository proprietaireRepository;
        @Override
        public ResponseDTO addPropritaire(Proprietaire proprietaire) {
            if(proprietaire == null || proprietaire == new Proprietaire()){
                return new ResponseDTO("bad request","information is required");

            }else if (userService.findUserByTelephone(proprietaire.getTelephone()).getData() != null ){
                return new ResponseDTO("bad request","this user with this phone is present");

            }else if(userService.findUserByEmail(proprietaire.getEmail()).getData() != null){
                return new ResponseDTO("bad request","user with this email is present");

            }else {
                adresseService.addAdressse(proprietaire.getAdresse());
                proprietaire.setStatus(Status.Desactive);
                proprietaireRepository.save(proprietaire);
                return new ResponseDTO("success","user is added");
            }
        }

    @Override
    public ResponseDTO findPropritaireByStatusDesactive(Status status) {
        return new ResponseDTO("success","Onners",proprietaireRepository.findByStatus(status));
    }
}
