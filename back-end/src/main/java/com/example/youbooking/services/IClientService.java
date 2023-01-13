package com.example.youbooking.services;

import com.example.youbooking.entities.Client;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IClientService {
    public ResponseDTO addClient(Client client, MultipartFile file);
}
