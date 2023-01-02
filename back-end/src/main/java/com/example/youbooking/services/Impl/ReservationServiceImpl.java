package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Chamber;
import com.example.youbooking.entities.Reservation;
import com.example.youbooking.entities.StatusChamber;
import com.example.youbooking.entities.StatusReservation;
import com.example.youbooking.repositories.ReservationRepository;
import com.example.youbooking.services.IChamberService;
import com.example.youbooking.services.IReservationService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
   public ReservationRepository reservationRepository;

    @Autowired
    IChamberService chamberService;

    @Override
    public ResponseDTO addReservation(Reservation reservation) {
        if(reservation == null || reservation == new Reservation()){
            return new ResponseDTO("bad request","this is required");

        }else if (reservation.getDateDebut().isBefore(LocalDate.now())
                && reservation.getDateFin().isBefore(reservation.getDateDebut())){
            return new ResponseDTO("bad date","no date selected");


        }else if (checkRoomReservedOrNo(reservation)){

            return new ResponseDTO("reserved","this room is reserved in this date");

        } else if (this.findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
                reservation.getChamber(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                StatusReservation.Accepte) == reservation) {
            return new ResponseDTO("reserved","this room is reserved in this date");

        }else {
            reservationRepository.save(reservation);
            chamberService.updateStatusChamber(reservation.getChamber().getId(),StatusChamber.Indisponible);
            return new ResponseDTO("success","your reservation is success",reservation);
        }
    }

    @Override
    public ResponseDTO updateReservation(Reservation reservation) {
        if(reservation == null || reservation == new Reservation()){
            return new ResponseDTO("bad request","this is required");

        }else if (reservation.getDateDebut().isBefore(LocalDate.now())
                && reservation.getDateFin().isBefore(reservation.getDateDebut())){
            return new ResponseDTO("bad","no date selected");


        }else if (checkRoomReservedOrNo(reservation)){

            return new ResponseDTO("reserved","this room is reserved in this date");

        } else if (this.findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
                reservation.getChamber(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                StatusReservation.Accepte) == reservation) {
            return new ResponseDTO("reserved","this room is reserved in this date");

        }else {
           Reservation reservationFind =  reservationRepository.findById(reservation.getId()).get();
            reservationFind.setStatusReservation(reservation.getStatusReservation());
            reservationRepository.save(reservationFind);
            return new ResponseDTO("success","your reservation is success",reservationFind);
        }
    }

    @Override
    public ResponseDTO annulerReservation(Long idResrvation) {
        Optional<Reservation> reservation = reservationRepository.findById(idResrvation);
        if(!reservation.isPresent()){
            return new ResponseDTO("bad request","this reservaton dnt present");
        }else {
            reservationRepository.deleteById(idResrvation);
            chamberService.updateStatusChamber(reservation.get().getChamber().getId(), StatusChamber.Disponible);
            return new ResponseDTO("success","your reservation is cancel");
        }
    }

    @Override
    public ResponseDTO findAllResrvations() {
        return new ResponseDTO("success","list reservation",reservationRepository.findAll());
    }

    @Override
    public ResponseDTO findOneResrvation(Long idResrvation) {
        Optional<Reservation> reservation = reservationRepository.findById(idResrvation);
        if (!reservation.isPresent()){
            return new ResponseDTO("bad request","this reservation dont present");
        }else {
            return new ResponseDTO("success","reservation",reservation);
        }
    }

    @Override
    public List<Reservation> findByClientAndStatus(Long idClient, StatusReservation status) {
        return reservationRepository.findReservationByClientAndStatusReservation(idClient,status);
    }

    @Override
    public List<Reservation> findByStatus(StatusReservation status) {
        return reservationRepository.findReservationByStatusReservation(status);
    }

    @Override
    public List<Reservation> findReservationByChamberAndStatusReservation(Long idChamber, StatusReservation status) {
        List<Reservation> reservations = reservationRepository
                .findReservationByChamberAndStatusReservation(
                        idChamber,
                        StatusReservation.Accepte);

        return reservations;
    }

    @Override
    public Reservation findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
            Chamber chamber
            ,LocalDate dateDebut
            ,LocalDate dateFin
            ,StatusReservation status) {

        Reservation reservation = reservationRepository
                .findReservationByChamberAndDateDebutAndAndDateFinAndStatusReservation(
                chamber
                ,dateDebut
                ,dateFin
                ,status);

        return reservation;
    }


    public boolean checkRoomReservedOrNo(Reservation reservation){
        reservation.getChamber().getReservationList().forEach(reservation1 -> {
            if (reservation1.getDateDebut().isEqual(reservation.getDateDebut()) || reservation1.getDateFin().isEqual(reservation.getDateFin())){
                System.out.println("resreved");
                return;
            }
        });
        return true;
    }
}
