package com.example.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserDto implements Serializable {
    private Long id;
    @NotNull
    @NotEmpty
    private String email;
    @NotEmpty @NotNull
    private String telephone;
    @NotNull @NotEmpty
    private String nom;
    @NotNull @NotEmpty
    private String password;
    private String photo;
    private RoleDto role;
    private AdresseDto adresse;

    public UserDto(String email, String telephone, String nom, String password, RoleDto role, AdresseDto adresse) {
        this.email = email;
        this.telephone = telephone;
        this.nom = nom;
        this.password = password;
        this.role = role;
        this.adresse = adresse;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
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
