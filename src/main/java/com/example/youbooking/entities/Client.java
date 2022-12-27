package com.example.youbooking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client extends User{
    @OneToMany(mappedBy = "client")
    private List<Reservation>  reservationList;

    public Client(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Client(String nom, String email, String telephone, String password, Status status, Role role, Adresse adresse, List<Reservation> reservationList) {
        super(nom, email, telephone, password, status, role, adresse);
        this.reservationList = reservationList;
    }

    public Client() {
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
