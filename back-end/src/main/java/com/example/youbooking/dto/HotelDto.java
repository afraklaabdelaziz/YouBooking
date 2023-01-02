package com.example.youbooking.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class HotelDto implements Serializable {
    private Long id;
    @NotEmpty @NotNull
    private String nom;
    @NotEmpty @NotNull
    private String telephone;
    private String photo;
    private AdresseDto adresse;

    public HotelDto(String nom, String telephone, AdresseDto adresse) {
        this.nom = nom;
        this.telephone = telephone;
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

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
