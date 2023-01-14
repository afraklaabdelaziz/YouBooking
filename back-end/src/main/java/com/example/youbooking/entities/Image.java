package com.example.youbooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] picByte;

    @OneToMany(mappedBy = "image")
    private Set<Hotel> hotels;

    @OneToMany(mappedBy = "image")
    private Set<User> users;

    public Image() {
    }

    public Image(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    @JsonIgnore
    public Set<Hotel> getHotels() {
        return hotels;
    }
    @JsonSetter
    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }
    @JsonSetter
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
