package com.example.youbooking.dto;

import java.io.Serializable;

public class HotelDto implements Serializable {
    private Long id;
    private String nom;
    private String telephone;
    private String status;
    private AdresseDto adresse;

    public HotelDto(String nom, String telephone, String status, AdresseDto adresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.status = status;
        this.adresse = adresse;
    }

    public HotelDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }
}
