package com.example.youbooking.dto;

import java.io.Serializable;

public class ChamberDto implements Serializable {
    private Long id;
    private Integer numero;
    private Double prix;
    private Integer nomberLits;
    private String photo;
    private HotelDto hotel;

    public ChamberDto(Long id, Integer numero, Double prix, Integer nomberLits, HotelDto hotel) {
        this.id = id;
        this.numero = numero;
        this.prix = prix;
        this.nomberLits = nomberLits;
        this.hotel = hotel;
    }

    public ChamberDto() {
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

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
