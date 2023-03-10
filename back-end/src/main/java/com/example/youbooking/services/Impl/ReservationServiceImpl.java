package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.*;
import com.example.youbooking.repositories.ClientRepository;
import com.example.youbooking.repositories.ReservationRepository;
import com.example.youbooking.services.*;
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

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    IUserService userService;
    @Autowired
    IProprietaireService proprietaireService;

    @Override
    public ResponseDTO addReservation(Reservation reservation, Long idChamber, Long idClient) {
        if(reservation == null || reservation == new Reservation()){
            return new ResponseDTO("bad request","this is required");

        }else if (reservation.getDateDebut().isBefore(LocalDate.now())
                || reservation.getDateFin().isBefore(reservation.getDateDebut())){
            return new ResponseDTO("bad date","date selected is bad ");


        } else if (this.findReservationByChamberAndDateDebutAndAndDateFinAndStatus(
                reservation.getChamber(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                StatusReservation.Accepte) == reservation) {
            return new ResponseDTO("reserved","this room is reserved in this date");

        }else {
          Chamber chamber = (Chamber) chamberService.findOneChamber(idChamber).getData();
            Optional<Client> client = clientRepository.findById(idClient);
            reservation.setChamber(chamber);
            reservation.setClient(client.get());
            reservation.setStatusReservation(StatusReservation.Encours);
            reservationRepository.save(reservation);
            chamberService.updateStatusChamber(idChamber,StatusChamber.Indisponible);
            return new ResponseDTO("success","your reservation is success",reservation);
        }
    }

    @Override
    public ResponseDTO updateReservation(Reservation reservation) {
        if(reservation == null || reservation == new Reservation()){
            return new ResponseDTO("bad request","this is required");

        }else if (reservation.getDateDebut().isBefore(LocalDate.now())
                || reservation.getDateFin().isBefore(reservation.getDateDebut())){
            return new ResponseDTO("bad","no date selected");


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
            return new ResponseDTO("bad request","this reservation not exist ");
        }else {
            reservationRepository.deleteById(idResrvation);
            chamberService.updateStatusChamber(reservation.get().getChamber().getId(), StatusChamber.Disponible);
            return new ResponseDTO("success","your reservation is cancel");
        }
    }

    @Override
    public List<Reservation> findAllResrvations() {
       return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findAllReservationOfHotelOwner(String email) {
        Proprietaire proprietaire = (Proprietaire) proprietaireService.getUserByEmail(email).getData();
        return reservationRepository.findAllReservationOfHotelOwner(proprietaire.getId());
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
    public List<Reservation> findByClientAndStatus(String email) {
         Client client = clientRepository.findClientByEmail(email);
        return reservationRepository.findReservationByClientId(client.getId());
    }

    @Override
    public List<Reservation> findByStatus(String email) {
        Proprietaire proprietaire = (Proprietaire) proprietaireService.getUserByEmail(email).getData();
        return reservationRepository.findAllReservationOfHotelOwnerAndStatusEncours(proprietaire.getId(),StatusReservation.Encours);
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

    @Override
    public ResponseDTO updateStatusReservation(Long idReservation, StatusReservation status){
        Optional<Reservation> reservation = reservationRepository.findById(idReservation);
        if (!reservation.isPresent()){
            return new ResponseDTO("bad request","reservation doesn't exist");
        }else {
            if (status.equals(StatusReservation.Accepte)) {
                reservation.get().setStatusReservation(StatusReservation.Accepte);
                chamberService.updateStatusChamber(reservation.get().getChamber().getId(), StatusChamber.Indisponible);
                reservationRepository.save(reservation.get());
                return new ResponseDTO("success", "your reservation is accepted");

            } else if (status.equals(StatusReservation.Refuse)) {
                reservation.get().setStatusReservation(StatusReservation.Refuse);
                reservationRepository.save(reservation.get());
                return new ResponseDTO("success", "your reservation is refused");

            } else {
                return new ResponseDTO("attend", "attend");
            }
        }

    }

}
