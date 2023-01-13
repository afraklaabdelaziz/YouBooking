package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusChamber;
import com.example.youbooking.repositories.ChamberRepository;
import com.example.youbooking.services.IChamberService;
import com.example.youbooking.services.IHotelService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ChamberServiceImpl implements IChamberService {

    @Autowired
    public ChamberRepository chamberRepository;
    @Autowired
    IHotelService hotelService;

    @Override
    public ResponseDTO addChamber(Chamber chamber) {
        if(chamber == null || chamber == new Chamber()){
            return new ResponseDTO("bad request","room is required");
        }
        else if(chamber.getHotel() == null) {
            return new ResponseDTO("bad request","hotel first");

        }else{

            chamber.setStatusChamber(StatusChamber.Disponible);
            System.out.println(chamber.getHotel().getId());
           Hotel hotel = (Hotel) hotelService.findOneHotel(chamber.getHotel().getId()).getData();
            chamber.setHotel(hotel);
            chamberRepository.save(chamber);
            return new ResponseDTO("success","your room has been successfully added",chamber);
        }
    }

    @Override
    public ResponseDTO updateChamber(Chamber chamber, Long idHotel) {
        Hotel hotel = (Hotel) hotelService.findOneHotel(idHotel).getData();
        chamber.setHotel(hotel);
        if(chamber == null || chamber == new Chamber() ){
            return new ResponseDTO("bad request","room is required");
        }
        else if(chamber.getHotel() == null) {
            return new ResponseDTO("bad request","hotel first");

        }else {
            Chamber chamberFound = chamberRepository.findById(chamber.getId()).get();
            chamberFound.setNomberLits(chamber.getNomberLits());
            chamberFound.setNumero(chamber.getNumero());
            chamberFound.setPrix(chamber.getPrix());
            chamberRepository.save(chamberFound);
            return new ResponseDTO("success","your room is updated",chamberFound);
        }
    }

    @Transactional
    @Override
    public ResponseDTO deleteChamber(Long idChamber) {
        Optional<Chamber> chamber = chamberRepository.findById(idChamber);
        if(!chamber.isPresent()){
            return new ResponseDTO("bad request","this room doesn't exist");
        }else{
            chamberRepository.delete(chamber.get());
            return new ResponseDTO("success","Room is deleted",chamber.get());
        }

    }

    @Override
    public ResponseDTO findAllChamber() {
        return new ResponseDTO("success","rooms",chamberRepository.findAll());
    }

    @Override
    public ResponseDTO findOneChamber(Long idChamber) {
        Optional<Chamber> chamber = chamberRepository.findById(idChamber);
        if(!chamber.isPresent()){
            return new ResponseDTO("bad request","this room doesn't exist");
        }
        return new ResponseDTO("success","your room ",chamber);
    }

    @Override
    public ResponseDTO updateStatusChamber(Long idChamber, StatusChamber status) {
        Optional<Chamber> chamberFound = chamberRepository.findById(idChamber);
        if(!chamberFound.isPresent()){
            return new ResponseDTO("bad request","this room doesn't exist");
        }else {
                chamberFound.get().setStatusChamber(status);
                chamberRepository.save(chamberFound.get());
                return new ResponseDTO("success", "room updated", chamberFound);
            }
        }

    @Override
    public List<Chamber> findChambersBySatatus(Reservation reservation, String ville){
        return chamberRepository.findAllByStatusChamber(StatusChamber.Disponible, ville,reservation.getDateDebut());
    }


//    public boolean checkListContainsObjet(List<Reservation> list ,Reservation reservation){
//        return list.stream().map(Reservation::getClass).filter(reservation::equals).findFirst().isPresent();
//    }
}
