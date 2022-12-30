package com.example.youbooking.dto;

import java.io.Serializable;

public class AdresseDto implements Serializable {
    private Long id;
    private String ville;
    private String pays;
    private String adresse;
    private String codePostal;

    public AdresseDto(String ville, String pays, String adresse, String codePostal) {
        this.ville = ville;
        this.pays = pays;
        this.adresse = adresse;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdresseDto() {
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
