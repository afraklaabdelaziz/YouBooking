package com.example.youbooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Client extends User{
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
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

    @JsonIgnore
    public List<Reservation> getReservationList() {
        return reservationList;
    }
    @JsonSetter
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
