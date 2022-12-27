package com.example.youbooking.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatusReservation statusReservation;
    @ManyToOne
    private Chamber chamber;
    @ManyToOne
    private Client client;

    public Reservation(LocalDate dateDebut, LocalDate dateFin, StatusReservation statusReservation, Chamber chamber, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statusReservation = statusReservation;
        this.chamber = chamber;
        this.client = client;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
