package com.example.youbooking.repositories;

import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {
    public List<Proprietaire> findByStatus(Status status);
}
