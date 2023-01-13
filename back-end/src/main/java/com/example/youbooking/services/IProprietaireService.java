package com.example.youbooking.services;

import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IProprietaireService {
    ResponseDTO addPropritaire(Proprietaire proprietaire, MultipartFile file);
    ResponseDTO findPropritaireByStatusDesactive(Status status);

    ResponseDTO getUserByEmail(String email);
}
