package com.example.youbooking.dto;

import com.sun.istack.NotNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ChamberDto implements Serializable {
    private Long id;
    @NotEmpty
    @NotNull
    private Integer numero;
    @NotEmpty @NotNull
    private Double prix;
    @NotEmpty @NotNull
    private Integer nomberLits;
    private String status;
    @Valid
    private HotelDto hotel;

    public ChamberDto(Long id, Integer numero, Double prix, Integer nomberLits, String status, HotelDto hotel) {
        this.id = id;
        this.numero = numero;
        this.prix = prix;
        this.nomberLits = nomberLits;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }
}
