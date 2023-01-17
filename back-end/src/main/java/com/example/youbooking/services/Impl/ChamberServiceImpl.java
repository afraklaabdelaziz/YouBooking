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

import java.time.LocalDate;
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
        if (chamber == null || chamber == new Chamber()) {
            return new ResponseDTO("bad request", "room is required");
        } else if (chamber.getHotel() == null) {
            return new ResponseDTO("bad request", "hotel first");
        } else if (chamber.getPrix() <= 0){
            return new ResponseDTO("bad request","price has been than 0");
        } else {

            chamber.setStatusChamber(StatusChamber.Disponible);
            Hotel hotel = (Hotel) hotelService.findOneHotel(chamber.getHotel().getId()).getData();
            chamber.setHotel(hotel);
            chamberRepository.save(chamber);
            return new ResponseDTO("success", "your room has been successfully added", chamber);
        }
    }

    @Override
    public ResponseDTO updateChamber(Chamber chamber, Long idHotel) {
        Hotel hotel = (Hotel) hotelService.findOneHotel(idHotel).getData();
        chamber.setHotel(hotel);
        if (chamber == null || chamber == new Chamber()) {
            return new ResponseDTO("bad request", "room is required");
        } else if (chamber.getHotel() == null) {
            return new ResponseDTO("bad request", "hotel first");

        } else {
            Chamber chamberFound = chamberRepository.findById(chamber.getId()).get();
            chamberFound.setNomberLits(chamber.getNomberLits());
            chamberFound.setNumero(chamber.getNumero());
            chamberFound.setPrix(chamber.getPrix());
            chamberRepository.save(chamberFound);
            return new ResponseDTO("success", "your room is updated", chamberFound);
        }
    }

    @Transactional
    @Override
    public ResponseDTO deleteChamber(Long idChamber) {
        Optional<Chamber> chamber = chamberRepository.findById(idChamber);
        if (!chamber.isPresent()) {
            return new ResponseDTO("bad request", "this room doesn't exist");
        } else {
            chamberRepository.delete(chamber.get());
            return new ResponseDTO("success", "Room is deleted", chamber.get());
        }

    }

    @Override
    public ResponseDTO findAllChamber() {
        return new ResponseDTO("success", "rooms", chamberRepository.findAll());
    }

    @Override
    public ResponseDTO findOneChamber(Long idChamber) {
        Optional<Chamber> chamber = chamberRepository.findById(idChamber);
        if (!chamber.isPresent()) {
            return new ResponseDTO("bad request", "this room doesn't exist");
        }
        return new ResponseDTO("success", "your room ", chamber.get());
    }

    @Override
    public ResponseDTO updateStatusChamber(Long idChamber, StatusChamber status) {
        Optional<Chamber> chamberFound = chamberRepository.findById(idChamber);
        if (!chamberFound.isPresent()) {
            return new ResponseDTO("bad request", "this room doesn't exist");
        } else {
            chamberFound.get().setStatusChamber(status);
            chamberRepository.save(chamberFound.get());
            return new ResponseDTO("success", "room updated", chamberFound);
        }
    }


    @Override
    public ResponseDTO allRoomsDesponible(Reservation reservation, String ville) {
        if (reservation.getDateDebut().isBefore(LocalDate.now())
                || reservation.getDateFin().isBefore(reservation.getDateDebut())) {
            return new ResponseDTO("bad date", "date selected is bad ");
        } else {
            List<Chamber> chambersNoReserved = chamberRepository.findAllByVilleNoReserved(ville);
            List<Chamber> chamberNoReservedInDate = chamberRepository.findListRoomNoReservedInDate(reservation.getDateDebut(), reservation.getDateFin(), ville);
            chambersNoReserved.addAll(chamberNoReservedInDate);
            return new ResponseDTO("success", "rooms No reserved", chambersNoReserved);
        }


//    public boolean checkListContainsObjet(List<Reservation> list ,Reservation reservation){
//        return list.stream().map(Reservation::getClass).filter(reservation::equals).findFirst().isPresent();
//    }
    }

    @Override
    public Integer countRoom(String email) {
        return chamberRepository.countAllByHotelProprietaireEmail(email);
    }
}
