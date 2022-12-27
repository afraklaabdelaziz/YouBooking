package com.example.youbooking.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Chamber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Double prix;
    private Integer nomberLits;
    private StatusChamber statusChamber;
    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "chamber")
    private List<Reservation> reservationList;


    public Chamber(Integer numero, Double prix, Integer nomberLits, StatusChamber statusChamber, Hotel hotel) {
        this.numero = numero;
        this.prix = prix;
        this.nomberLits = nomberLits;
        this.statusChamber = statusChamber;
        this.hotel = hotel;
    }

    public Chamber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getNomberLits() {
        return nomberLits;
    }

    public void setNomberLits(Integer nomberLits) {
        this.nomberLits = nomberLits;
    }

    public StatusChamber getStatusChamber() {
        return statusChamber;
    }

    public void setStatusChamber(StatusChamber statusChamber) {
        this.statusChamber = statusChamber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
