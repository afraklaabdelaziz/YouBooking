package com.example.youbooking.services;

import com.example.youbooking.entities.Adresse;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IAdresseService {
    public ResponseDTO addAdressse(Adresse adresse);
    public ResponseDTO updateAdresse(Adresse adresse);
}
