package com.example.youbooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ville;
    private String pays;
    private String adresse;
    private String codePostal;
    @OneToMany(mappedBy = "adresse")
    private List<User> users;

    public Adresse(String ville, String pays, String adresse, String codePostal, List<User> users) {
        this.ville = ville;
        this.pays = pays;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.users = users;
    }

    public Adresse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
@JsonIgnore
    public List<User> getUsers() {
        return users;
    }
@JsonSetter
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
