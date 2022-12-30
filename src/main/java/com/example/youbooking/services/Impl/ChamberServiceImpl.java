package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.repositories.ChamberRepository;
import com.example.youbooking.services.IChamberService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamberServiceImpl implements IChamberService {

    @Autowired
    public ChamberRepository chamberRepository;

    @Override
    public ResponseDTO addChamber(Chamber chamber) {
        if(chamber == null || chamber == new Chamber()){
            return new ResponseDTO("bad request","room is required");
        }else{
            return new ResponseDTO("success","your room has been successfully added",chamber);
        }
    }

    @Override
    public ResponseDTO updateChamber(Chamber chamber) {
        if(chamber == null || chamber == new Chamber()){
            return new ResponseDTO("bad request","room is required");
        }else {
            Chamber chamberFind = chamberRepository.findById(chamber.getId()).get();
            chamberFind.setNomberLits(chamber.getNomberLits());
            chamberFind.setNumero(chamber.getNumero());
            chamberFind.setStatusChamber(chamber.getStatusChamber());
            chamberFind.setPrix(chamber.getPrix());
            return new ResponseDTO("success","your room is updated",chamberFind);
        }

    }

    @Override
    public ResponseDTO deleteChamber(Long idChamber) {
        Chamber chamber = chamberRepository.findById(idChamber).get();
        if(chamber == null){
            return new ResponseDTO("bad request","this room dont present");
        }else{
            chamberRepository.delete(chamber);
            return new ResponseDTO("success","chamber is delete",chamber);
        }

    }

    @Override
    public ResponseDTO findAllChamber() {
        return new ResponseDTO("success","rooms",chamberRepository.findAll());
    }

    @Override
    public ResponseDTO findOneChamber(Long idChamber) {
        Chamber chamber = chamberRepository.findById(idChamber).get();
        if(chamber == null){
            return new ResponseDTO("bad request","this room dont present");
        }
        return new ResponseDTO("success","your room ",chamber);
    }
}
