package com.example.youbooking.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {
    private String nom;
    private Long id;

    public RoleDto(String nom) {
        this.nom = nom;
    }

    public RoleDto() {
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
}
