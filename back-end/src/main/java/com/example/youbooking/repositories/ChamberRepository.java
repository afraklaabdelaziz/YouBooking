package com.example.youbooking.repositories;

import com.example.youbooking.entities.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamberRepository extends JpaRepository<Chamber,Long> {
}
