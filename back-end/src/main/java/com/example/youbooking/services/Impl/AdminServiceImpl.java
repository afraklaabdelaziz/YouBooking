package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import com.example.youbooking.repositories.ProprietaireRepository;
import com.example.youbooking.services.IAdminService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    ProprietaireRepository proprietaireRepository;
    @Override
    public ResponseDTO acceptePropritaire(Long idPropritaire) {
       Optional<Proprietaire> proprietaire = proprietaireRepository.findById(idPropritaire);
        if (!proprietaire.isPresent()){
            return new ResponseDTO("bad request","this Onner dont present");
        }else {
            proprietaire.get().setStatus(Status.Active);
            proprietaireRepository.save(proprietaire.get());
            return new ResponseDTO("success","Onner accepted");
        }
    }
}
