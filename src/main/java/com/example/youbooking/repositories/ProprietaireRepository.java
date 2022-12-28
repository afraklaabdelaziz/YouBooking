package com.example.youbooking.repositories;

import com.example.youbooking.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {
}
