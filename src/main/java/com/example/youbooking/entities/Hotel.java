package com.example.youbooking.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String telephone;
    private Status status;
    @OneToOne
    private Adresse adresse;
    @ManyToOne
    private Proprietaire proprietaire;
    @OneToMany(mappedBy = "hotel")
    private List<Chamber> chambers;
    @ManyToOne
    private Admin admin;

    public Hotel(String nom, String telephone, Status status, Adresse adresse, Proprietaire proprietaire) {
        this.nom = nom;
        this.telephone = telephone;
        this.status = status;
        this.adresse = adresse;
        this.proprietaire = proprietaire;
    }

    public Hotel() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public List<Chamber> getChambers() {
        return chambers;
    }

    public void setChambers(List<Chamber> chambers) {
        this.chambers = chambers;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
