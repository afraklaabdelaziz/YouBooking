package com.example.youbooking.services;

import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IProprietaireService {
    ResponseDTO addPropritaire(Proprietaire proprietaire);
}
