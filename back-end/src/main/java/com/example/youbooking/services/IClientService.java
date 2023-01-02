package com.example.youbooking.services;

import com.example.youbooking.entities.Client;
import com.example.youbooking.services.dto.ResponseDTO;

public interface IClientService {
    public ResponseDTO addClient(Client client);
}
