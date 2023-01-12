package com.example.youbooking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Proprietaire extends User{
    @OneToMany(mappedBy = "proprietaire",cascade = CascadeType.ALL)
    private List<Hotel> hotels;

    public Proprietaire(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Proprietaire(String nom, String email, String telephone, String password, Status status, Role role, Adresse adresse, List<Hotel> hotels) {
        super(nom, email, telephone, password, status, role, adresse);
        this.hotels = hotels;
    }

    public Proprietaire() {
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
