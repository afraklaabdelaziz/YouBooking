package com.example.youbooking.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Admin extends User{
    @OneToMany(mappedBy = "admin")
    private List<Hotel> hotels;

    public Admin(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Admin(String nom, String email, String telephone, String password, Status status, Role role, Adresse adresse, List<Hotel> hotels) {
        super(nom, email, telephone, password, status, role, adresse);
        this.hotels = hotels;
    }

    public Admin() {

    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
