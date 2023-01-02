package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Adresse;
import com.example.youbooking.repositories.AdresseRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements IAdresseService {

    @Autowired
   public AdresseRepository adresseRepository;

    @Override
    public ResponseDTO addAdressse(Adresse adresse) {
        if (adresse == null || adresse == new Adresse()){
            return new ResponseDTO("bad Request","adresse is requered");

        }else{
            adresseRepository.save(adresse);
            return new ResponseDTO("success","your adresse has been successfully added",adresse);
        }

    }

    @Override
    public ResponseDTO updateAdresse(Adresse adresse) {
        if (adresse == null || adresse == new Adresse()){
            return new ResponseDTO("bad Request","adresse is requered");

        }else {
            Adresse adresseFind = adresseRepository.findById(adresse.getId()).get();
            adresseFind.setAdresse(adresse.getAdresse());
            adresseFind.setCodePostal(adresse.getCodePostal());
            adresseFind.setPays(adresse.getPays());
            adresseFind.setVille(adresse.getVille());
            return new ResponseDTO("success","your adresse has been successfully update",adresseFind);
        }

    }
}
