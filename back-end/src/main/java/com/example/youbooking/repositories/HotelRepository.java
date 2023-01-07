package com.example.youbooking.repositories;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    public List<Hotel> findHotelByStatus(Status status);

    public List<Hotel> findHotelByProprietaireAndStatus(Long idProprietaire , Status status);
}
